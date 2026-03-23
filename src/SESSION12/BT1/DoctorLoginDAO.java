package SESSION12.BT1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DoctorLoginDAO {

    public void login(String doctorCode, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM Doctors WHERE code = ? AND pass = ?";
            conn = DBContext.getHospitalConn();
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, doctorCode);
            pstmt.setString(2, password);

            rs = pstmt.executeQuery();

            if (rs.next()) {
                System.out.println("Đăng nhập thành công!");
            } else {
                System.out.println("Sai thông tin đăng nhập.");
            }
    }

    /*
     * * 1. Tại sao PreparedStatement chống được SQL Injection?
     * - Cơ chế Pre-compiled (Biên dịch trước): Câu lệnh SQL được gửi lên Database để chốt khung
     * cấu trúc trước khi nạp dữ liệu. Hacker không thể dùng lệnh ' OR '1'='1 để sửa logic.
     * * 2. Tác dụng của dấu hỏi chấm (?):
     * - Dấu ? đóng vai trò là "vị trí giữ chỗ" cho dữ liệu thô. Mọi thứ người dùng nhập vào
     * đều bị Java coi là văn bản bình thường (String), không thể thực thi như một câu lệnh.
     * * 3. Lợi ích:
     * - Bảo vệ dữ liệu nhạy cảm của bệnh viện và giúp hệ thống chạy ổn định, chuyên nghiệp hơn.
     */
}