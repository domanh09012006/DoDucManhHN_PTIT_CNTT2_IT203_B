package SESSION08;

import java.util.Scanner;

interface DiscountStrategy {
    double calculate(double amount);
}

interface PaymentMethod {
    void process(double amount);
}

interface NotificationService {
    void send(String message);
}

class WebsiteDiscount implements DiscountStrategy {
    public double calculate(double amount) { return amount * 0.1; }
}

class MobileDiscount implements DiscountStrategy {
    public double calculate(double amount) { return amount * 0.15; }
}

class POSDiscount implements DiscountStrategy {
    public double calculate(double amount) { return amount * 0.05; }
}

class CreditCardPayment implements PaymentMethod {
    public void process(double amount) { System.out.println("Xu ly thanh toan the tin dung: " + (long)amount); }
}

class MomoPayment implements PaymentMethod {
    public void process(double amount) { System.out.println("Xu ly thanh toan MoMo: " + (long)amount); }
}

class CODPayment implements PaymentMethod {
    public void process(double amount) { System.out.println("Xu ly thanh toan tien mat (COD): " + (long)amount); }
}

class EmailNotification implements NotificationService {
    public void send(String message) { System.out.println("Gui email: " + message); }
}

class PushNotification implements NotificationService {
    public void send(String message) { System.out.println("Gui push notification: " + message); }
}

class PrintReceipt implements NotificationService {
    public void send(String message) { System.out.println("In hoa don: " + message); }
}

interface SalesChannelFactory {
    DiscountStrategy createDiscount();
    PaymentMethod createPayment();
    NotificationService createNotification();
}

class WebsiteFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() { return new WebsiteDiscount(); }
    public PaymentMethod createPayment() { return new CreditCardPayment(); }
    public NotificationService createNotification() { return new EmailNotification(); }
}

class MobileAppFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() { return new MobileDiscount(); }
    public PaymentMethod createPayment() { return new MomoPayment(); }
    public NotificationService createNotification() { return new PushNotification(); }
}

class POSFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() { return new POSDiscount(); }
    public PaymentMethod createPayment() { return new CODPayment(); }
    public NotificationService createNotification() { return new PrintReceipt(); }
}

class OrderService {
    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        this.discount = factory.createDiscount();
        this.payment = factory.createPayment();
        this.notification = factory.createNotification();
    }

    public void processOrder(String product, double price) {
        double discountAmount = discount.calculate(price);
        double finalAmount = price - discountAmount;
        System.out.println("SanPham: " + product + " gia " + (long)price);
        System.out.println("Ap dung giam gia: " + (long)discountAmount);
        payment.process(finalAmount);
        notification.send("Don hang thanh cong");
    }
}

public class BT6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SalesChannelFactory factory = null;

        System.out.println("--- HE THONG BAN HANG DA KENH ---");
        System.out.println("1. Website");
        System.out.println("2. Mobile App");
        System.out.println("3. POS tai cua hang");
        System.out.print("Chon kenh: ");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                factory = new WebsiteFactory();
                System.out.println("Ban da chon kenh Website");
                break;
            case 2:
                factory = new MobileAppFactory();
                System.out.println("Ban da chon kenh Mobile App");
                break;
            case 3:
                factory = new POSFactory();
                System.out.println("Ban da chon kenh POS");
                break;
            default:
                System.out.println("Lua chon sai!");
                return;
        }

        OrderService orderService = new OrderService(factory);
        orderService.processOrder("Laptop/Dien thoai", 15000000);
    }
}
