package SESSION07.BT5.repository;

import SESSION07.BT5.model.Order;
import java.util.ArrayList;
import java.util.List;

public class FileOrderRepository implements OrderRepository {
    private List<Order> orders = new ArrayList<>();
    public void save(Order order) {
        orders.add(order);
        System.out.println("Đã lưu đơn hàng " + order.getId());
    }
    public List<Order> findAll() {
        return orders;
    }
}
