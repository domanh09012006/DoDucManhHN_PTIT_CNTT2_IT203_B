package SESSION08.BT2;

public class SmartHomeFacade {
    private TemperatureSensor sensor;
    public SmartHomeFacade(TemperatureSensor sensor) {
        this.sensor = sensor;
    }
    public void getCurrentTemperature() {
        System.out.println("Nhiệt độ hiện tại: " + sensor.getTemperatureCelsius() + "°C (chuyển đổi từ 78°F)");
    }
    public void leaveHome() {
        System.out.println("Tắt đèn");
        System.out.println("Tắt quạt");
        System.out.println("Tắt điều hòa");
    }
    public void sleepMode() {
        System.out.println("Tắt đèn");
        System.out.println("Điều hòa set 28°C");
        System.out.println("Quạt chạy tốc độ thấp");
    }
}