package SESSION07.BT5.payment;

public class MomoPayment implements PaymentMethod {
    @Override
    public void pay(double amount) {
        System.out.println("Thanh toán MoMo: " + amount);
    }
}
