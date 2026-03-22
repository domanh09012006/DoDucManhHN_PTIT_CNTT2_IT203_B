package SESSION11.BT4;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



public class PatientSearch {

    public void searchByName(Connection conn, String patientName) throws SQLException {
        if (patientName.contains("'") ||
                patientName.contains("--") ||
                patientName.contains(";")) {
            System.out.println("Input không hợp lệ!");
            return;
        }
        String sql = "SELECT * FROM Patients WHERE full_name = '" + patientName + "'";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);
        while (rs.next()) {
            System.out.println("Tên: " + rs.getString("full_name"));
        }
    }
}
/*
 * PHÂN TÍCH:
 * - Giá trị nhập vào: "' OR '1'='1"
 * - Khi nối chuỗi SQL:
 *   SELECT * FROM Patients WHERE full_name = '' OR '1'='1'
 *
 * - Phân tích:
 *   + full_name = '' -> thường là false
 *   + '1'='1' -> luôn đúng (true)
 *
 * - Do có toán tử OR:
 *   false OR true -> true
 *
 * => Mệnh đề WHERE luôn đúng với mọi dòng
 * => Kết quả: trả về toàn bộ dữ liệu bệnh nhân
 *
 * -> Đây là lỗi SQL Injection do nối chuỗi trực tiếp
 *
 * CÁCH KHẮC PHỤC:
 *
 * - Kiểm tra và loại bỏ các ký tự nguy hiểm:
 *   + '  (nháy đơn)
 *   + -- (comment SQL)
 *   + ;  (kết thúc câu lệnh)
 *
 * - Nếu phát hiện ký tự này -> không cho phép truy vấn
 */