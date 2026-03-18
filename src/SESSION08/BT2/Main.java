package SESSION08.BT2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        OldThermometer oldSensor = new OldThermometer();
        TemperatureSensor adapter = new ThermometerAdapter(oldSensor);
        SmartHomeFacade smartHome = new SmartHomeFacade(adapter);
        Scanner sc = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n--- MENU ĐIỀU KHIỂN ---");
            System.out.println("1. Xem nhiệt độ");
            System.out.println("2. Chế độ rời nhà");
            System.out.println("3. Chế độ ngủ");
            System.out.println("0. Thoát");
            System.out.print("Chọn: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    smartHome.getCurrentTemperature();
                    break;
                case 2:
                    smartHome.leaveHome();
                    break;
                case 3:
                    smartHome.sleepMode();
                    break;
            }
        } while (choice != 0);
    }
}