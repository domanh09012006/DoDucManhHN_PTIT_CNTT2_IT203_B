package SESSION09;

import java.util.ArrayList;
import java.util.List;

public class ProductDatabase {
    private List<Product> list = new ArrayList<>();

    public void addProduct(Product p) {
        list.add(p);
    }

    public List<Product> getAll() {
        return list;
    }

    public void deleteProduct(String id) {
        list.removeIf(p -> p.getId().equals(id));
    }
}