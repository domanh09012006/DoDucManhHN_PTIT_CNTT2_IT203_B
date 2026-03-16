package SESSION07.BT5.service;

import SESSION07.BT5.notification.NotificationService;
import SESSION07.BT5.repository.OrderRepository;
import SESSION07.BT5.discount.DiscountStrategy;
import SESSION07.BT5.model.Order;
import SESSION07.BT5.payment.PaymentMethod;

public class OrderService {
    private OrderRepository repository;
    private NotificationService notification;
    public OrderService(OrderRepository repository, NotificationService notification) {
        this.repository = repository;
        this.notification = notification;
    }

    public double processOrder(Order order, DiscountStrategy discount, PaymentMethod payment) {
        double total = order.getTotal();
        double finalAmount = discount.applyDiscount(total);
        payment.pay(finalAmount);
        repository.save(order);
        notification.send("Đơn hàng " + order.getId() + " đã tạo", order.getCustomer().getEmail());
        return finalAmount;
    }
}
