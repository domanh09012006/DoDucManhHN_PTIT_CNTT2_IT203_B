package SESSION07.BT6.payment;

public class CashPayment implements PaymentMethod {
    public void pay(double amount) {
        System.out.println("Thanh toán tiền mặt tại cửa hàng");
    }
}