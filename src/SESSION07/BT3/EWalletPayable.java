package SESSION07.BT3;

public interface EWalletPayable extends PaymentMethod {
    void processEWallet(double amount);
}
