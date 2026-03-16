package SESSION07.BT5.payment;

public class CODPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán COD: " + amount);
    }
}
