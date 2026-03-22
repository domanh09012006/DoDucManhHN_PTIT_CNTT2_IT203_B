package SESSION11.BT5.business;

import SESSION11.BT5.dao.DoctorDAO;
import SESSION11.BT5.model.Doctor;

import java.util.List;

public class DoctorService {
    private DoctorDAO dao = new DoctorDAO();
    public void showDoctors() {
        List<Doctor> list = dao.getAllDoctors();

        if (list.isEmpty()) {
            System.out.println("Không có bác sĩ.");
        } else {
            for (Doctor d : list) {
                System.out.println(d.getId() + " | " + d.getName() + " | " + d.getSpecialty()
                );
            }
        }
    }
    public void addDoctor(Doctor d) {
        if (dao.addDoctor(d)) {
            System.out.println("Thêm thành công!");
        } else {
            System.out.println("Thêm thất bại!");
        }
    }
    public void statistic() {
        dao.statisticBySpecialty();
    }
}