package SESSION11.BT1;

import java.sql.*;

public class PatientDAO {
    public void displayPatient(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = DBContext.getConnection();
            pstmt = conn.prepareStatement("SELECT name FROM patients WHERE id = ?");
            pstmt.setInt(1, id);
            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Bệnh nhân: " + rs.getString("name"));
            }
        } finally {
            if (rs != null) rs.close();
            if (pstmt != null) pstmt.close();
            if (conn != null) conn.close();
            System.out.println("Hệ thống: Đã dọn dẹp và đóng kết nối.");
        }
    }
}
