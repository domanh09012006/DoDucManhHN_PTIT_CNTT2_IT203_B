package SESSION13.BT2;

import SESSION13.BT1.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BillingService {

    public void thanhToanVienPhi(int patientId, int invoiceId, double amount) {
        Connection conn = null;
        try {
            conn = DBContext.getConnection();
            conn.setAutoCommit(false);

            String sqlDeductWallet = "UPDATE Patient_Wallet SET balance = balance - ? WHERE patient_id = ?";
            PreparedStatement ps1 = conn.prepareStatement(sqlDeductWallet);
            ps1.setDouble(1, amount);
            ps1.setInt(2, patientId);
            ps1.executeUpdate();

            String sqlUpdateInvoice = "UPDATE Invoicesss SET status = 'PAID' WHERE invoice_id = ?";
            PreparedStatement ps2 = conn.prepareStatement(sqlUpdateInvoice);
            ps2.setInt(1, invoiceId);
            ps2.executeUpdate();

            conn.commit();
            System.out.println("Thanh toan hoan tat!");

        } catch (SQLException e) {
            if (conn != null) {
                try {
                    conn.rollback();
                    System.out.println("Da xoa bo giao dich, hoan tien an toan.");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
            System.out.println("Loi he thong: Khong the hoan tat thanh toan. Chi tiet: " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    /*
     * - In loi (println) chi la cho nguoi doc, Database khong tu biet de huy giao dich. Neu de im, DB se bi treo (lock) du lieu, gay lang phi tai nguyen.
     * - Hanh dong thieu: Bat buoc phai goi `conn.rollback()` de hoan tac (tra lai tien) ve trang thai cu.
     * - Chu y: Phai bo try-with-resources (dua Connection ra ngoai) moi goi duoc conn.rollback() trong catch.
     */
}
