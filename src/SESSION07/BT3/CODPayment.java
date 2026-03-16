package SESSION07.BT3;

public class CODPayment implements CODPayable {
    @Override
    public void processCOD(double amount) {
        System.out.println("Xử lý thanh toán COD: " + amount + " - Thành công");
    }

    @Override
    public void processPayment(double amount) {

    }
}