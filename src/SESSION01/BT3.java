package SESSION01;

import java.util.Scanner;

class User {
    private int age;
    public void setAge(int age) {
        if (age < 0) {
            throw new IllegalArgumentException("Tuoi khong the am");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}
public class BT3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        try {
            System.out.print("Nhap tuoi nguoi dung: ");
            int age = sc.nextInt();
            user.setAge(age);
            System.out.println("Tuoi da duoc luu: " + user.getAge());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
