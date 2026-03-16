package SESSION07.BT5.discount;

public class HolidayDiscount implements DiscountStrategy {
    @Override
    public double applyDiscount(double total) {
        return total * 0.85;
    }
}
