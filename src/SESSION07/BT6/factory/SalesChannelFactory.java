package SESSION07.BT6.factory;

import SESSION07.BT6.discount.DiscountStrategy;
import SESSION07.BT6.notification.NotificationService;
import SESSION07.BT6.payment.PaymentMethod;

public interface SalesChannelFactory {
    DiscountStrategy createDiscount();
    PaymentMethod createPayment();
    NotificationService createNotification();
}
