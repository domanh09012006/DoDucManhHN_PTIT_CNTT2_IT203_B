package SESSION07.BT6.factory;

import SESSION07.BT6.discount.DiscountStrategy;
import SESSION07.BT6.discount.StoreDiscount;
import SESSION07.BT6.notification.NotificationService;
import SESSION07.BT6.notification.PrintNotification;
import SESSION07.BT6.payment.CashPayment;
import SESSION07.BT6.payment.PaymentMethod;

public class StoreFactory implements SalesChannelFactory {

    public DiscountStrategy createDiscount() {
        return new StoreDiscount();
    }

    public PaymentMethod createPayment() {
        return new CashPayment();
    }

    public NotificationService createNotification() {
        return new PrintNotification();
    }
}
