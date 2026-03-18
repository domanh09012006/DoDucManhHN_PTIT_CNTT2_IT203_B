package SESSION08.BT1;

public class HardwareConnection {
    private static HardwareConnection instance;
    private HardwareConnection() {
        System.out.println("HardwareConnection: Đã kết nối phần cứng.");
    }
    public static HardwareConnection getInstance() {
        if (instance == null) {
            instance = new HardwareConnection();
        }
        return instance;
    }
    public void connect() {
    }
    public void disconnect() {
        System.out.println("HardwareConnection: Ngắt kết nối.");
    }
}
