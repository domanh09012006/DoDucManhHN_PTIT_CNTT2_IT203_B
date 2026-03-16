package SESSION07.BT6.discount;

public class StoreDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        System.out.println("Giảm giá 5% cho thành viên tại cửa hàng");
        return total * 0.95;
    }
}
