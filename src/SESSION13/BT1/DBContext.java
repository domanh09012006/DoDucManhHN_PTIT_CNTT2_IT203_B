package SESSION13.BT1;

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
    public static Connection getHospitalConn() {
        try {
            return getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }
}