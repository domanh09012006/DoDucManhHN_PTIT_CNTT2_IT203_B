package SESSION11.BT2;

import SESSION11.BT1.DBContext;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Pharmacy {

    public void showMedicines() {
        try {
            Connection conn = DBContext.getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT medicine_name, stock FROM Pharmacy");
            while (rs.next()) {
                String name = rs.getString("medicine_name");
                int stock = rs.getInt("stock");
                System.out.println("Tên thuốc: " + name + " | Số lượng tồn kho: " + stock);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
/*
 * - if(rs.next()) chỉ chạy 1 lần -> chỉ lấy dòng đầu tiên
 * - Trong khi yêu cầu là in danh sách (nhiều dòng)
 *
 * - ResultSet hoạt động như sau:
 *   + Ban đầu con trỏ ở trước dòng đầu tiên
 *   + Mỗi lần rs.next() -> di chuyển xuống 1 dòng
 *   + Nếu còn dữ liệu -> true, hết -> false
 *
 * => Phải dùng while(rs.next()) để duyệt hết dữ liệu
 */