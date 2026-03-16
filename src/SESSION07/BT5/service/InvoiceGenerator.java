package SESSION07.BT5.service;

import SESSION07.BT5.model.Order;
import SESSION07.BT5.model.OrderItem;

public class InvoiceGenerator {
    public void printInvoice(Order order, double finalAmount) {
        System.out.println("=== HÓA ĐƠN ===");
        System.out.println("Khách: " + order.getCustomer().getName());
        for (OrderItem i : order.getItems()) {
            System.out.println(i.getProduct().getName() + " - SL: " + i.getQuantity() + " - Thành tiền: " + i.getTotal()
            );
        }
        System.out.println("Cần thanh toán: " + finalAmount);
    }
}
