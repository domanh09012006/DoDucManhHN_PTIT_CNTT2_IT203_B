package SESSION08.BT1;

public class Light implements Device {
    public Light() {
        System.out.println("LightFactory: Đã tạo đèn mới.");
    }
    @Override
    public void turnOn() {
        System.out.println("Đèn: Bật sáng.");
    }
    @Override
    public void turnOff() {
        System.out.println("Đèn: Tắt.");
    }
}
