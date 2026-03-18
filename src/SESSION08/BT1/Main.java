package SESSION08.BT1;

import java.util.*;

public class Main {
    static List<Device> devices = new ArrayList<>();
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Kết nối phần cứng");
            System.out.println("2. Tạo thiết bị");
            System.out.println("3. Bật thiết bị");
            System.out.println("4. Tắt thiết bị");
            System.out.println("5. Thoát");

            System.out.print("Chọn: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    HardwareConnection connection = HardwareConnection.getInstance();
                    connection.connect();
                    break;

                case 2:
                    System.out.println("1. Đèn");
                    System.out.println("2. Quạt");

                    int type = sc.nextInt();

                    DeviceFactory factory = null;

                    if (type == 1) {
                        factory = new LightFactory();
                    } else if (type == 2) {
                        factory = new FanFactory();
                    }

                    if (factory != null) {
                        Device device = factory.createDevice();
                        devices.add(device);
                    }
                    break;

                case 3:
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println((i + 1) + ". Thiết bị " + (i + 1));
                    }

                    int on = sc.nextInt();
                    devices.get(on - 1).turnOn();
                    break;

                case 4:
                    for (int i = 0; i < devices.size(); i++) {
                        System.out.println((i + 1) + ". Thiết bị " + (i + 1));
                    }

                    int off = sc.nextInt();
                    devices.get(off - 1).turnOff();
                    break;

                case 5:
                    return;
            }
        }
    }
}
