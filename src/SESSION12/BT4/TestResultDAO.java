package SESSION12.BT4;

import SESSION12.BT1.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class TestResultDAO {

    public void insertResults(List<String> listData) throws SQLException {
        Connection conn = DBContext.getHospitalConn();
        String sql = "INSERT INTO Results(data) VALUES(?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        for (String data : listData) {
            pstmt.setString(1, data);
            pstmt.executeUpdate();
        }

        System.out.println("Da nap xong " + listData.size() + " ket qua xet nghiem!");
    }

    /*
     * 1. Tai sao code cu lai lang phi tai nguyen?
     * - Voi Statement cu (noi chuoi), Database coi moi cau lenh la "duy nhat".
     * - Neu co 1.000 ket qua, Database phai thuc hien 1.000 lan cac buoc:
     * Kiem tra cu phap (Parse) -> Phan tich logic -> Lap ke hoach thuc thi (Execution Plan).
     * - Viec nay giong nhu ban phai ve lai ban do thanh pho 1.000 lan chi de giao 1.000 goi hang.
     * * 2. Toi uu bang PreparedStatement:
     * - Khi khoi tao ngoai vong lap, Database chi phai Parse va lap ke hoach dung 1 LAN duy nhat.
     * - Cac lan sau trong vong lap, no chi viec "thay ruot" du lieu vao va chay ngay.
     */
}
