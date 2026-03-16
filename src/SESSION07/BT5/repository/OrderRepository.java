package SESSION07.BT5.repository;

import SESSION07.BT5.model.Order;
import java.util.List;
public interface OrderRepository {
    void save(Order order);
    List<Order> findAll();
}
