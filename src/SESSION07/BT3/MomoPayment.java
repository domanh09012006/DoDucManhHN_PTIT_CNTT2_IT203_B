package SESSION07.BT3;

public class MomoPayment implements EWalletPayable {
    @Override
    public void processEWallet(double amount) {
        System.out.println("Xử lý thanh toán MoMo: " + amount + " - Thành công");
    }
    @Override
    public void processPayment(double amount) {

    }
}
