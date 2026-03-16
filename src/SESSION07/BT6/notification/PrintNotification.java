package SESSION07.BT6.notification;

public class PrintNotification implements NotificationService {
    public void send(String message) {
        System.out.println("In hóa đơn giấy: " + message);
    }
}