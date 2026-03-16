package SESSION07.BT6.service;

import SESSION07.BT6.discount.DiscountStrategy;
import SESSION07.BT6.factory.SalesChannelFactory;
import SESSION07.BT6.model.Order;
import SESSION07.BT6.notification.NotificationService;
import SESSION07.BT6.payment.PaymentMethod;

public class OrderService {

    private DiscountStrategy discount;
    private PaymentMethod payment;
    private NotificationService notification;

    public OrderService(SalesChannelFactory factory) {
        discount = factory.createDiscount();
        payment = factory.createPayment();
        notification = factory.createNotification();
    }
    public void processOrder(Order order) {
        double total = order.getTotal();
        double finalAmount = discount.applyDiscount(total);
        payment.pay(finalAmount);
        notification.send("Đơn hàng thành công");
    }
}
