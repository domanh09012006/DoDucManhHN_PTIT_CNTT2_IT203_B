package SESSION01;

import java.util.Scanner;

public class BT1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.print("Nhap nam sinh cua ban: ");
            String input = sc.nextLine();
            int birthYear = Integer.parseInt(input);
            int currentYear = 2026;
            int age = currentYear - birthYear;
            System.out.println("Tuoi cua ban la: " + age);
        } catch (NumberFormatException e) {
            System.out.println("nhap nam sinh bang so");
        } finally {
            sc.close();
            System.out.println("Thuc hien don dep tai nguyen trong finally...");
        }
    }
}