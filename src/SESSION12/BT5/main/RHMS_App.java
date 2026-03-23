package SESSION12.BT5.main;

// Import lop PatientDAO tu package dao
import SESSION12.BT5.dao.PatientDAO;
import java.util.Scanner;

public class RHMS_App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PatientDAO dao = new PatientDAO();

        while (true) {
            System.out.println("\n=== HE THONG QUAN LY NOI TRU RHMS ===");
            System.out.println("1. Danh sach benh nhan");
            System.out.println("2. Tiep nhan benh nhan moi");
            System.out.println("3. Cap nhat benh an");
            System.out.println("4. Xuat vien & Tinh phi");
            System.out.println("5. Thoat");
            System.out.print("Chon chuc nang (1-5): ");

            int choice = Integer.parseInt(scanner.nextLine());

            try {
                switch (choice) {
                    case 1:
                        dao.getAllPatients();
                        break;
                    case 2:
                        System.out.print("Nhap ten BN (VD: D'Arcy): ");
                        String name = scanner.nextLine();
                        System.out.print("Nhap tuoi: ");
                        int age = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhap khoa (VD: Hoi suc): ");
                        String dept = scanner.nextLine();
                        dao.admitPatient(name, age, dept);
                        break;
                    case 3:
                        System.out.print("Nhap ID benh nhan: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhap thong tin benh an moi: ");
                        String record = scanner.nextLine();
                        dao.updateMedicalRecord(id, record);
                        break;
                    case 4:
                        System.out.print("Nhap ID benh nhan xuat vien: ");
                        int dischargeId = Integer.parseInt(scanner.nextLine());
                        System.out.print("Nhap so ngay nam vien: ");
                        int days = Integer.parseInt(scanner.nextLine());
                        dao.calculateDischargeFee(dischargeId, days);
                        break;
                    case 5:
                        System.out.println("Thoat he thong. Chuc bac si mot ngay tot lanh!");
                        System.exit(0);
                    default:
                        System.out.println("Lua chon khong hop le!");
                }
            } catch (Exception e) {
                System.out.println("Loi he thong: " + e.getMessage());
            }
        }
    }
}
