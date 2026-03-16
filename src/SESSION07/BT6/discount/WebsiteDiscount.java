package SESSION07.BT6.discount;

public class WebsiteDiscount implements DiscountStrategy {
    public double applyDiscount(double total) {
        System.out.println("Áp dụng giảm giá 10% cho đơn hàng website");
        return total * 0.9;
    }
}
