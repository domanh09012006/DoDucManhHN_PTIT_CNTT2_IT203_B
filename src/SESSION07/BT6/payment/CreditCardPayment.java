package SESSION07.BT6.payment;

public class CreditCardPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Xử lý thanh toán thẻ tín dụng qua cổng thanh toán online");
    }
}
