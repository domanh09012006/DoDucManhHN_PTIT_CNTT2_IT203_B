package SESSION07.BT5.model;

import java.util.ArrayList;
import java.util.List;

public class Order {

    private String id;
    private Customer customer;
    private List<OrderItem> items = new ArrayList<>();
    public Order(String id, Customer customer) {
        this.id = id;
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
    public String getId() { return id; }

    public Customer getCustomer() { return customer; }

    public List<OrderItem> getItems() { return items; }
}
