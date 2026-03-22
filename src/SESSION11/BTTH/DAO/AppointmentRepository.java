package SESSION11.BTTH.DAO;

import SESSION11.BTTH.DatabaseConnection;
import SESSION11.BTTH.Model.Appointment;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AppointmentRepository {

    // Thêm lịch khám
    public void addAppointment(Appointment a) throws SQLException {
        String sql = "INSERT INTO appointments (patient_name, appointment_date, doctor_name, status) VALUES (?, ?, ?, ?)";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, a.getPatientName());
        ps.setDate(2, a.getAppointmentDate());
        ps.setString(3, a.getDoctorName());
        ps.setString(4, a.getStatus());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    // Cập nhật
    public void updateAppointment(Appointment a) throws SQLException {
        String sql = "UPDATE appointments SET patient_name=?, appointment_date=?, doctor_name=?, status=? WHERE id=?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setString(1, a.getPatientName());
        ps.setDate(2, a.getAppointmentDate());
        ps.setString(3, a.getDoctorName());
        ps.setString(4, a.getStatus());
        ps.setInt(5, a.getId());

        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    // Xóa
    public void deleteAppointment(int id) throws SQLException {
        String sql = "DELETE FROM appointments WHERE id=?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ps.executeUpdate();

        ps.close();
        conn.close();
    }

    // Lấy theo ID
    public Appointment getAppointmentById(int id) throws SQLException {
        String sql = "SELECT * FROM appointments WHERE id=?";

        Connection conn = DatabaseConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement(sql);

        ps.setInt(1, id);
        ResultSet rs = ps.executeQuery();

        Appointment a = null;

        if (rs.next()) {
            a = new Appointment(
                    rs.getInt("id"),
                    rs.getString("patient_name"),
                    rs.getDate("appointment_date"),
                    rs.getString("doctor_name"),
                    rs.getString("status")
            );
        }

        rs.close();
        ps.close();
        conn.close();

        return a;
    }

    // Lấy tất cả
    public List<Appointment> getAllAppointments() throws SQLException {
        List<Appointment> list = new ArrayList<>();

        String sql = "SELECT * FROM appointments";

        Connection conn = DatabaseConnection.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            Appointment a = new Appointment(
                    rs.getInt("id"),
                    rs.getString("patient_name"),
                    rs.getDate("appointment_date"),
                    rs.getString("doctor_name"),
                    rs.getString("status")
            );
            list.add(a);
        }

        rs.close();
        stmt.close();
        conn.close();

        return list;
    }
}
