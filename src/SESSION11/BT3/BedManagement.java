package SESSION11.BT3;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class BedManagement {
    public void updateBedStatus(Connection conn, int bedId) throws SQLException {
        String sql = "UPDATE Beds SET bed_status = ? WHERE bed_id = ?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1, "Occupied");
        ps.setInt(2, bedId);
        int rows = ps.executeUpdate();
        if (rows > 0) {
            System.out.println("Đã cập nhật giường bệnh thành công!");
        } else {
            System.out.println("Lỗi: Mã giường không tồn tại!");
        }
    }
}

/*
 * PHÂN TÍCH:
 * - executeUpdate() trả về số dòng bị ảnh hưởng.
 * - Nếu > 0:
 *    -> Cập nhật thành công
 * - Nếu = 0:
 *    -> Không có giường nào được cập nhật
 *    -> Nghĩa là mã giường không tồn tại
 * Cần kiểm tra giá trị trả về để thông báo chính xác
 */