package SESSION07.BT2;

public class OrderCalculator {
    private DiscountStrategy discountStrategy;
    public OrderCalculator(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    public double calculateTotal(double totalAmount) {
        return discountStrategy.applyDiscount(totalAmount);
    }
}