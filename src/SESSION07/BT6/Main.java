package SESSION07.BT6;

import SESSION07.BT6.factory.MobileFactory;
import SESSION07.BT6.factory.SalesChannelFactory;
import SESSION07.BT6.factory.StoreFactory;
import SESSION07.BT6.factory.WebsiteFactory;
import SESSION07.BT6.model.Customer;
import SESSION07.BT6.model.Order;
import SESSION07.BT6.model.OrderItem;
import SESSION07.BT6.model.Product;
import SESSION07.BT6.service.OrderService;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Chọn kênh bán:");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS Store");

        int choice = sc.nextInt();

        SalesChannelFactory factory = null;

        switch (choice) {

            case 1:
                factory = new WebsiteFactory();
                System.out.println("Bạn đã chọn kênh Website");
                break;

            case 2:
                factory = new MobileFactory();
                System.out.println("Bạn đã chọn kênh Mobile App");
                break;

            case 3:
                factory = new StoreFactory();
                System.out.println("Bạn đã chọn kênh POS");
                break;

            default:
                System.out.println("Lựa chọn không hợp lệ");
                return;
        }

        Product p = new Product("Laptop", 15000000);
        Customer c = new Customer("Nguyễn Văn A");

        Order order = new Order(c);
        order.addItem(new OrderItem(p, 1));

        OrderService service = new OrderService(factory);
        service.processOrder(order);
    }

}