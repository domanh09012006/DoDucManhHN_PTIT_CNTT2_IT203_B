package SESSION12.BT2;

import SESSION12.BT1.DBContext;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class VitalsDAO {

    public void updateVitals(int patientId, double temp, int heartRate) throws SQLException {
        Connection conn = DBContext.getHospitalConn();

        String sql = "UPDATE Vitals SET temperature = ?, heart_rate = ? WHERE p_id = ?";

        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setDouble(1, temp);
        pstmt.setInt(2, heartRate);
        pstmt.setInt(3, patientId);

        int rows = pstmt.executeUpdate();

        if (rows > 0) {
            System.out.println("Cap nhat chi so sinh ton thanh cong!");
        } else {
            System.out.println("Khong tim thay benh nhan de cap nhat.");
        }
    }

    /*
     * 1. Tai sao setDouble(), setInt() lai giup tranh loi dinh dang?
     * - Khi dung noi chuoi (Statement), Java phai bien con so thanh chuoi (String). Neu may dung
     * kieu Viet Nam (37,5), SQL se hieu nham dau phay la dau ngan cach cac cot, gay loi cu phap.
     * - Khi dung setDouble(), du lieu duoc truyen duoi dang "nhi phan" (binary) truc tiep den Database.
     * - Database se tu hieu gia tri so ma khong quan tam den viec hien thi la dau cham hay dau phay.
     * 2. Loi ich:
     * - Giup code chay dung tren moi may tinh ma khong can quan tam den cai dat vung mien (Locale).
     * - Tranh cac loi "Syntax Error" ngo ngan khi lam viec voi so thap phan.
     */
}
