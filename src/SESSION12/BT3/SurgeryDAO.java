package SESSION12.BT3;

import SESSION12.BT1.DBContext;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;

public class SurgeryDAO {

    public void getSurgeryFee(int surgeryId) throws SQLException {
        Connection conn = DBContext.getHospitalConn();
        String sql = "{call GET_SURGERY_FEE(?, ?)}";
        CallableStatement cstmt = conn.prepareCall(sql);
        cstmt.setInt(1, surgeryId);
        cstmt.registerOutParameter(2, Types.DECIMAL);
        cstmt.execute();
        double totalCost = cstmt.getDouble(2);

        System.out.println("Chi phi phau thuat cho ID " + surgeryId + " la: " + totalCost + " VND");
    }

    /*
     * 1. Tai sao bat buoc goi registerOutParameter()?
     * - Mac dinh JDBC chi hieu cac dau ? la de truyen du lieu vao (IN).
     * - Khi dung Stored Procedure, co nhung dau ? dung de "hung" du lieu tra ve (OUT).
     * - Ta phai dang ky truoc de Java biet cach "dat cho" va chuan bi kieu du lieu phu hop
     * de nhan ket qua tu Database sau khi execute xong.
     * 2. DECIMAL trong SQL tuong ung voi hang so nao trong Java?
     * - Trong lop java.sql.Types, kieu DECIMAL se duoc dang ky bang hang so: Types.DECIMAL.
     * - Viec dang ky dung kieu giup tranh loi "Column index out of range" hoac sai dinh dang tien te.
     */
}
