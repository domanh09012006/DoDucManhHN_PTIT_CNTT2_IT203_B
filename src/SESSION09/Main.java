package SESSION09;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ProductDatabase db = new ProductDatabase();
        while (true) {
            System.out.println("""
                    ---------------------- QUẢN LÝ SẢN PHẨM ----------------------
                    1. Thêm mới sản phẩm
                    2. Xem danh sách sản phẩm
                    3. Xoá sản phẩm
                    4. Thoát
                    -----------------------------------------------------------------------
                    Lựa chọn của bạn:
                    """);
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 1:
                    System.out.print("1: Physical, 2: Digital: ");
                    int type = Integer.parseInt(sc.nextLine());
                    System.out.print("ID: ");
                    String id = sc.nextLine();
                    System.out.print("Name: ");
                    String name = sc.nextLine();
                    System.out.print("Price: ");
                    double price = Double.parseDouble(sc.nextLine());
                    if (type == 1) {
                        System.out.print("Weight: ");
                        double weight = Double.parseDouble(sc.nextLine());
                        Product p = new PhysicalProduct(id, name, price, weight);
                        db.addProduct(p);
                    } else {
                        System.out.print("Size: ");
                        double size = Double.parseDouble(sc.nextLine());
                        Product p = new DigitalProduct(id, name, price, size);
                        db.addProduct(p);
                    }
                    System.out.println("Thêm thành công");
                    break;
                case 2:
                    for (Product product : db.getAll()) {
                        product.displayInfo();
                    }
                    break;
                case 3:
                    System.out.print("Nhập ID cần xoá: ");
                    String deleteId = sc.nextLine();
                    db.deleteProduct(deleteId);
                    System.out.println("Đã xoá");
                    break;

                case 4:
                    System.out.println("Thoát chương trình");
                    return;

                default:
                    System.out.println("Không có lựa chọn này!");
            }
        }
    }
}