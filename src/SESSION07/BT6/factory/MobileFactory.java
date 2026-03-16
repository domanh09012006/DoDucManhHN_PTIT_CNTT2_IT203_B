package SESSION07.BT6.factory;

import SESSION07.BT6.discount.DiscountStrategy;
import SESSION07.BT6.discount.MobileDiscount;
import SESSION07.BT6.notification.NotificationService;
import SESSION07.BT6.notification.PushNotification;
import SESSION07.BT6.payment.MomoPayment;
import SESSION07.BT6.payment.PaymentMethod;

public class MobileFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() {
        return new MobileDiscount();
    }
    public PaymentMethod createPayment() {
        return new MomoPayment();
    }
    public NotificationService createNotification() {
        return new PushNotification();
    }
}
