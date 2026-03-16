package SESSION07.BT6.notification;

public class PushNotification implements NotificationService {
    public void send(String message) {
        System.out.println("Push notification: " + message);
    }
}
