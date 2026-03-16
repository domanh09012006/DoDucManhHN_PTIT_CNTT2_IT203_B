package SESSION07.BT5;

import SESSION07.BT5.discount.DiscountStrategy;
import SESSION07.BT5.discount.PercentageDiscount;
import SESSION07.BT5.model.Customer;
import SESSION07.BT5.model.Order;
import SESSION07.BT5.model.OrderItem;
import SESSION07.BT5.model.Product;
import SESSION07.BT5.notification.EmailNotification;
import SESSION07.BT5.notification.NotificationService;
import SESSION07.BT5.payment.CreditCardPayment;
import SESSION07.BT5.payment.PaymentMethod;
import SESSION07.BT5.repository.FileOrderRepository;
import SESSION07.BT5.repository.OrderRepository;
import SESSION07.BT5.service.InvoiceGenerator;
import SESSION07.BT5.service.OrderService;

import java.util.*;

public class Main {

    static List<Product> products = new ArrayList<>();
    static List<Customer> customers = new ArrayList<>();

    static OrderRepository repository = new FileOrderRepository();
    static NotificationService notification = new EmailNotification();
    static OrderService orderService = new OrderService(repository, notification);

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while (true) {

            System.out.println("\n===== MENU =====");
            System.out.println("1. Thêm sản phẩm");
            System.out.println("2. Thêm khách hàng");
            System.out.println("3. Tạo đơn hàng");
            System.out.println("4. Xem danh sách đơn hàng");
            System.out.println("5. Tính tổng doanh thu");
            System.out.println("0. Thoát");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addProduct();
                    break;
                case 2:
                    addCustomer();
                    break;
                case 3:
                    createOrder();
                    break;
                case 4:
                    showOrders();
                    break;
                case 5:
                    revenue();
                    break;
                case 0:
                    System.out.println("Thoát chương trình.");
                    return;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");

            }
        }
    }

    static void addProduct() {

        System.out.print("Mã sản phẩm: ");
        String id = sc.nextLine();

        System.out.print("Tên sản phẩm: ");
        String name = sc.nextLine();

        System.out.print("Giá: ");
        double price = sc.nextDouble();
        sc.nextLine();

        System.out.print("Danh mục: ");
        String cate = sc.nextLine();

        products.add(new Product(id, name, price, cate));

        System.out.println("Đã thêm sản phẩm " + id);
    }
    static void addCustomer() {

        System.out.print("Tên: ");
        String name = sc.nextLine();

        System.out.print("Email: ");
        String email = sc.nextLine();

        System.out.print("SĐT: ");
        String phone = sc.nextLine();

        customers.add(new Customer(name, email, phone));

        System.out.println("Đã thêm khách hàng");
    }
    static void createOrder() {
        if (customers.isEmpty() || products.isEmpty()) {
            System.out.println("Chưa có khách hàng hoặc sản phẩm");
            return;
        }

        Customer customer = customers.get(0);
        Product product = products.get(0);

        Order order = new Order("ORD" + (repository.findAll().size() + 1), customer);

        order.addItem(new OrderItem(product, 1));

        DiscountStrategy discount = new PercentageDiscount(10);

        PaymentMethod payment = new CreditCardPayment();

        double finalAmount = orderService.processOrder(order, discount, payment);

        InvoiceGenerator invoice = new InvoiceGenerator();

        invoice.printInvoice(order, finalAmount);
    }
    static void showOrders() {
        List<Order> orders = repository.findAll();
        for (Order o : orders) {
            System.out.println(o.getId() + " - " + o.getCustomer().getName());
        }
    }
    static void revenue() {
        double total = 0;
        for (Order o : repository.findAll()) {
            total += o.getTotal();
        }
        System.out.println("Tổng doanh thu: " + total);
    }
}