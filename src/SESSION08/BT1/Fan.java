package SESSION08.BT1;

public class Fan implements Device {
    public Fan() {
        System.out.println("FanFactory: Đã tạo quạt mới.");
    }
    @Override
    public void turnOn() {
        System.out.println("Quạt: Bật.");
    }
    @Override
    public void turnOff() {
        System.out.println("Quạt: Tắt.");
    }
}
