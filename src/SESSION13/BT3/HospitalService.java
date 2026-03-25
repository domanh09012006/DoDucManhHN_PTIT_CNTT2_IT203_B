package SESSION13.BT3;

import SESSION13.BT1.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HospitalService {

    public void xuatVienVaThanhToan(int maBenhNhan, double tienVienPhi) {
        Connection conn = null;
        PreparedStatement psCheck = null, psWallet = null, psBed = null, psPatient = null;
        ResultSet rs = null;

        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);

            // BAY 1: Thieu tien (Loi logic) - Lay so du len kiem tra truoc
            String sqlCheck = "SELECT balance FROM Patient_Wallet WHERE patient_id = ?";
            psCheck = conn.prepareStatement(sqlCheck);
            psCheck.setInt(1, maBenhNhan);
            rs = psCheck.executeQuery();

            if (rs.next()) {
                if (rs.getDouble("balance") < tienVienPhi) {
                    // Chu dong nem Exception de nhay vao catch -> Rollback
                    throw new Exception("TU CHOI: So du khong du de thanh toan!");
                }
            } else {
                throw new Exception("LOI: Khong tim thay vi benh nhan!");
            }

            // Thao tac 1: Tru tien
            String sqlWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            psWallet = conn.prepareStatement(sqlWallet);
            psWallet.setDouble(1, tienVienPhi);
            psWallet.setInt(2, maBenhNhan);

            // BAY 2: Du lieu ao (Row Affected = 0) - Khong co dong nao duoc update
            if (psWallet.executeUpdate() == 0) {
                throw new Exception("LOI: Tru tien that bai do ma benh nhan ao!");
            }

            // Thao tac 2: Giai phong giuong
            String sqlBed = "UPDATE Beds SET status = 'Trong' WHERE current_patient_id = ?";
            psBed = conn.prepareStatement(sqlBed);
            psBed.setInt(1, maBenhNhan);
            if (psBed.executeUpdate() == 0) {
                throw new Exception("LOI: Giai phong giuong that bai!"); // Xu ly bay 2
            }

            // Thao tac 3: Cap nhat trang thai benh nhan
            String sqlPatient = "UPDATE Patients SET status = 'Da xuat vien' WHERE patient_id = ?";
            psPatient = conn.prepareStatement(sqlPatient);
            psPatient.setInt(1, maBenhNhan);
            if (psPatient.executeUpdate() == 0) {
                throw new Exception("LOI: Cap nhat trang thai xuat vien that bai!"); // Xu ly bay 2
            }

            // Neu qua het cac ai tren -> Chot giao dich
            conn.commit();
            System.out.println("THANH CONG: Da hoan tat xuat vien!");

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("HUY GIAO DICH (Rollback) vi: " + e.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (psCheck != null) psCheck.close();
                if (psWallet != null) psWallet.close();
                if (psBed != null) psBed.close();
                if (psPatient != null) psPatient.close();
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
/*
     * 1. Phan tich bai toan (I/O)
     * - Input: maBenhNhan (int), tienVienPhi (double).
     * - Output: In console thong bao thanh cong, hoac ly do that bai kem thong bao da Rollback an toan.
     * * 2. De xuat giai phap
     * - Dung conn.setAutoCommit(false) gom 3 thao tac UPDATE vao 1 Transaction.
     * - Giai quyet Bay 1: SELECT so du truoc, dung cau lenh IF so sanh, nem Exception neu thieu tien de ep code nhay vao catch -> Rollback.
     * - Giai quyet Bay 2: Bat gia tri tra ve cua executeUpdate(). Neu == 0, nem Exception de Rollback (vi JDBC khong tu bao loi dong ao).
     * * 3. Thiet ke cac buoc
     * - B1: Mo Connection, tat Auto-Commit.
     * - B2: Khoi tao SELECT kiem tra so du -> Xu ly Bay 1.
     * - B3: Thuc thi UPDATE tru tien -> Xu ly Bay 2.
     * - B4: Thuc thi UPDATE giai phong giuong -> Xu ly Bay 2.
     * - B5: Thuc thi UPDATE trang thai benh nhan -> Xu ly Bay 2.
     * - B6: Goi commit() neu toan bo thanh cong.
     * - B7: Catch ngoai le, goi rollback() de don dep.
     * - B8: Dong ket noi tai finally.
     */
}
