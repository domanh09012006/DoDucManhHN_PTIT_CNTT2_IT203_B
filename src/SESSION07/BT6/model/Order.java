package SESSION07.BT6.model;

import java.util.ArrayList;
import java.util.List;

public class Order {
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    public Order(Customer customer) {
        this.customer = customer;
    }
    public void addItem(OrderItem item) {
        items.add(item);
    }
    public double getTotal() {
        double total = 0;
        for (OrderItem i : items) {
            total += i.getTotal();
        }
        return total;
    }
    public Customer getCustomer() {
        return customer;
    }
    public List<OrderItem> getItems() {
        return items;
    }
}
