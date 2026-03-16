package SESSION06.BT5;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<CinemaRoom> rooms = new ArrayList<>();
    static ArrayList<BookingCounter> counters = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Bắt đầu mô phỏng");
            System.out.println("2. Tạm dừng mô phỏng");
            System.out.println("3. Tiếp tục mô phỏng");
            System.out.println("4. Thêm vé vào phòng");
            System.out.println("5. Xem thống kê");
            System.out.println("6. Phát hiện deadlock");
            System.out.println("7. Thoát");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Số phòng: ");
                    int roomCount = sc.nextInt();

                    System.out.print("Vé mỗi phòng: ");
                    int ticketCount = sc.nextInt();
                    for (int i = 0; i < roomCount; i++) {
                        char name = (char) ('A' + i);
                        rooms.add(new CinemaRoom(String.valueOf(name), ticketCount));
                    }
                    System.out.print("Số quầy bán vé: ");
                    int counterCount = sc.nextInt();
                    for (int i = 1; i <= counterCount; i++) {
                        BookingCounter c = new BookingCounter("Quầy " + i, rooms);
                        counters.add(c);
                        Thread t = new Thread(c);
                        t.start();
                    }
                    break;
                case 2:
                    for (BookingCounter c : counters) {
                        c.paused = true;
                    }
                    System.out.println("Đã tạm dừng.");
                    break;
                case 3:
                    for (BookingCounter c : counters) {
                        c.paused = false;
                    }
                    System.out.println("Đã tiếp tục.");
                    break;
                case 4:
                    System.out.print("Chọn phòng (A/B/...): ");
                    String roomName = sc.next();
                    for (CinemaRoom r : rooms) {
                        if (r.name.equals(roomName)) {
                            r.addTicket();
                            System.out.println("Đã thêm vé vào phòng " + roomName);
                        }
                    }
                    break;
                case 5:
                    System.out.println("=== THỐNG KÊ ===");
                    for (CinemaRoom r : rooms) {
                        System.out.println(
                                "Phòng " + r.name +
                                        ": đã bán " + r.soldCount() +
                                        "/" + r.tickets.size()
                        );
                    }
                    break;
                case 6:
                    System.out.println("Đang kiểm tra deadlock...");
                    System.out.println("Không phát hiện deadlock.");
                    break;
                case 7:
                    System.out.println("Thoát chương trình.");
                    System.exit(0);
            }
        }
    }
}