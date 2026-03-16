package SESSION07.BT3;

public class Main {
    public static void main(String[] args) {
        PaymentProcessor processor = new PaymentProcessor();
        PaymentMethod cod = new CODPayment();
        PaymentMethod card = new CreditCardPayment();
        PaymentMethod momo = new MomoPayment();

        processor.processPayment(cod, 500000);
        processor.processPayment(card, 1000000);
        processor.processPayment(momo, 750000);

    }
}
