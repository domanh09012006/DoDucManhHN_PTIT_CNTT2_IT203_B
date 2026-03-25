package SESSION13.BT1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MedicineService {

    public void capPhatThuoc(int medicineId, int patientId) {
        Connection conn = null;
        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);

            String sqlUpdate = "UPDATE Medicine_Inventory SET quantity = quantity - 1 WHERE medicine_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlUpdate);
            ps1.setInt(1, medicineId);
            ps1.executeUpdate();

            String sqlInsert = "INSERT INTO Prescription_History (patient_id, medicine_id, date) VALUES (?, ?, GETDATE())";
            PreparedStatement ps2 = conn.prepareStatement(sqlInsert);
            ps2.setInt(1, patientId);
            ps2.setInt(2, medicineId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("Thanh cong!");

        } catch (Exception e) {
            if (conn != null) {
                try {
                    conn.rollback();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Loi: " + e.getMessage());
        } finally {
            try {
                if (conn != null) conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    /*
     * - JDBC mac dinh auto-commit = true (chay cau nao, luu luon cau do).
     * - Khi loi xay ra o giua, ps1 da luu roi nen ko undo duoc.
     * - Ket qua: Mat thuoc nhung ko co lich su -> Sai nghiep vu.
     */
}
