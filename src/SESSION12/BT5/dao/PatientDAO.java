package SESSION12.BT5.dao;

import SESSION12.BT5.util.DBContext;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class PatientDAO {

    public void getAllPatients() throws SQLException {
        Connection conn = DBContext.getHospitalConn();
        String sql = "SELECT id, name, age, department FROM Patients";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();

        System.out.println("\n--- DANH SACH BENH NHAN ---");
        while (rs.next()) {
            System.out.println("ID: " + rs.getInt("id") + " | Ten: " + rs.getString("name") +
                    " | Tuoi: " + rs.getInt("age") + " | Khoa: " + rs.getString("department"));
        }
    }

    public void admitPatient(String name, int age, String department) throws SQLException {
        Connection conn = DBContext.getHospitalConn();
        String sql = "INSERT INTO Patients(name, age, department) VALUES(?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, name);
        pstmt.setInt(2, age);
        pstmt.setString(3, department);

        pstmt.executeUpdate();
        System.out.println("=> Tiep nhan benh nhan thanh cong!");
    }

    public void updateMedicalRecord(int id, String newRecord) throws SQLException {
        Connection conn = DBContext.getHospitalConn();
        String sql = "UPDATE Patients SET medical_record = ? WHERE id = ?";
        PreparedStatement pstmt = conn.prepareStatement(sql);

        pstmt.setString(1, newRecord);
        pstmt.setInt(2, id);

        pstmt.executeUpdate();
        System.out.println("=> Cap nhat benh an thanh cong!");
    }

    public void calculateDischargeFee(int id, int days) throws SQLException {
        Connection conn = DBContext.getHospitalConn();
        String sql = "{call CALCULATE_DISCHARGE_FEE(?, ?, ?)}";
        CallableStatement cstmt = conn.prepareCall(sql);

        cstmt.setInt(1, id);
        cstmt.setInt(2, days);
        cstmt.registerOutParameter(3, Types.DECIMAL);

        cstmt.execute();
        double totalFee = cstmt.getDouble(3);

        System.out.println("=> Benh nhan ID " + id + " xuat vien. Tong vien phi: " + totalFee + " VND");
    }
}
