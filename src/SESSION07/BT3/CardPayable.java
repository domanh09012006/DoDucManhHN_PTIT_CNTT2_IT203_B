package SESSION07.BT3;

public interface CardPayable extends PaymentMethod {
    void processCard(double amount);
}
