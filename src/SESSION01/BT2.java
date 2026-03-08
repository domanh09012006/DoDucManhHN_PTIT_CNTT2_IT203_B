package SESSION01;

import java.util.Scanner;

public class BT2 {
    public static void main(String[] args) {
        Scanner sc  = new Scanner(System.in);
        System.out.print("Nhap tong so nguoi dung: ");
        int tongNguoi = sc.nextInt();
        System.out.print("Nhap so nhom muon chia: ");
        int soNhom = sc.nextInt();
        try {
            int soNguoiMoiNhom = tongNguoi / soNhom;
            System.out.println("Moi nhom co: " + soNguoiMoiNhom + " nguoi");
        } catch (ArithmeticException e) {
            System.out.println("Khong the chia cho 0");
        }
    }
}