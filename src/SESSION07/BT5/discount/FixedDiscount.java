package SESSION07.BT5.discount;

public class FixedDiscount implements DiscountStrategy {
    private double amount;
    public FixedDiscount(double amount) {
        this.amount = amount;
    }
    @Override
    public double applyDiscount(double total) {
        return total - amount;
    }
}
