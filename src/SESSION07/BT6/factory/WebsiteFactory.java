package SESSION07.BT6.factory;

import SESSION07.BT6.discount.DiscountStrategy;
import SESSION07.BT6.discount.WebsiteDiscount;
import SESSION07.BT6.notification.EmailNotification;
import SESSION07.BT6.notification.NotificationService;
import SESSION07.BT6.payment.CreditCardPayment;
import SESSION07.BT6.payment.PaymentMethod;

public class WebsiteFactory implements SalesChannelFactory {
    public DiscountStrategy createDiscount() {
        return new WebsiteDiscount();
    }
    public PaymentMethod createPayment() {
        return new CreditCardPayment();
    }
    public NotificationService createNotification() {
        return new EmailNotification();
    }
}
