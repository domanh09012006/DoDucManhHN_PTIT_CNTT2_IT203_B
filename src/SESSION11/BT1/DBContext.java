package SESSION11.BT1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBContext {

    private static final String URL = "jdbc:mysql://localhost:3306/Hospital_DB";
    private static final String USER = "root";
    private static final String PASSWORD = "12345678";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
/*
* Lỗi: Không đóng connection sau khi sử dụng.
* Gây rò rỉ tài nguyên, hết connection, hệ thống bị treo.
* Lỗi "Communications link failure" do connection bị timeout.
* Đặc biệt nguy hiểm với hệ thống 24/7 như bệnh viện.
* Cách khắc phục: Luôn đóng connection trong finally.
*/