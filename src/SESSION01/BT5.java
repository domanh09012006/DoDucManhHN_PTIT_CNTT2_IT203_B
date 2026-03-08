package SESSION01;

import java.util.Scanner;

class InvalidAgeException extends Exception {
    public InvalidAgeException(String msg) {
        super(msg);
    }
}
class User2 {
    private int age;
    public void setAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Tuoi khong the am!");
        }
        this.age = age;
    }
    public int getAge() {
        return age;
    }
}

public class BT5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        User2 user = new User2();
        try {
            System.out.print("Nhap tuoi nguoi dung: ");
            int age = sc.nextInt();
            user.setAge(age);
            System.out.println("Tuoi da duoc luu: " + user.getAge());
        } catch (InvalidAgeException e) {
            System.out.println("Loi: " + e.getMessage());
        }
    }
}