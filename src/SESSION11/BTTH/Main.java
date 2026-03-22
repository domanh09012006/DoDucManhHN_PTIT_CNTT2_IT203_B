package SESSION11.BTTH;

import SESSION11.BTTH.DAO.AppointmentRepository;
import SESSION11.BTTH.Model.Appointment;

import java.sql.Date;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        AppointmentRepository repo = new AppointmentRepository();

        // 1. Thêm
        Appointment a1 = new Appointment(
                "Nguyen Van A",
                Date.valueOf("2026-03-25"),
                "Dr. B",
                "Pending"
        );
        repo.addAppointment(a1);

        // 2. Hiển thị tất cả
        List<Appointment> list = repo.getAllAppointments();
        for (Appointment a : list) {
            System.out.println(a.getId() + " | " + a.getPatientName()
                    + " | " + a.getAppointmentDate()
                    + " | " + a.getDoctorName()
                    + " | " + a.getStatus());
        }

        // 3. Cập nhật
        if (!list.isEmpty()) {
            Appointment first = list.get(0);
            first.setStatus("Completed");
            repo.updateAppointment(first);
        }

        // 4. Xóa
        if (!list.isEmpty()) {
            repo.deleteAppointment(list.get(0).getId());
        }
    }
}
