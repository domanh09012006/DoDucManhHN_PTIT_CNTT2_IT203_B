package SESSION13.BT5;

import java.util.Scanner;

public class ReceptionView {
    private final ReceptionDAO dao = new ReceptionDAO();
    private final Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("\n=== HE THONG LE TAN RIKKEI HOSPITAL ===");
            System.out.println("1. Xem danh sach giuong trong");
            System.out.println("2. Tiep nhan benh nhan (1 Cham)");
            System.out.println("3. Thoat he thong");
            System.out.print("Chon chuc nang (1-3): ");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    dao.hienThiGiuongTrong();
                    break;
                case "2":
                    hienThiFormTiepNhan();
                    break;
                case "3":
                    System.out.println("Dang dong he thong... Tam biet!");
                    return;
                default:
                    System.out.println("Lua chon khong hop le!");
            }
        }
    }

    private void hienThiFormTiepNhan() {
        try {
            System.out.println("\n--- FORM TIEP NHAN BENH NHAN ---");
            System.out.print("Nhap ten benh nhan: ");
            String ten = scanner.nextLine();
            if (ten.trim().isEmpty()) throw new IllegalArgumentException("Ten khong duoc de trong!");

            System.out.print("Nhap tuoi: ");
            int tuoi = Integer.parseInt(scanner.nextLine());
            if (tuoi <= 0) throw new IllegalArgumentException("Tuoi phai lon hon 0!");

            System.out.print("Nhap ma giuong muon chon: ");
            int maGiuong = Integer.parseInt(scanner.nextLine());

            System.out.print("Nhap so tien tam ung (VND): ");
            double soTien = Double.parseDouble(scanner.nextLine());
            if (soTien < 0) throw new IllegalArgumentException("So tien khong hop le!");

            System.out.println("\nDang xu ly du lieu...");
            boolean ketQua = dao.tiepNhanBenhNhan(ten, tuoi, maGiuong, soTien);

            if (ketQua) {
                System.out.println("=> THANH CONG: Da tiep nhan benh nhan, xep giuong va thu tien!");
            } else {
                System.out.println("=> THAT BAI: Vui long thu lai!");
            }

        } catch (NumberFormatException e) {
            System.out.println("Loi: Vui long chi nhap so cho Tuoi, Ma giuong va So tien!");
        } catch (IllegalArgumentException e) {
            System.out.println("Loi: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Loi he thong: " + e.getMessage());
        }
    }
}
