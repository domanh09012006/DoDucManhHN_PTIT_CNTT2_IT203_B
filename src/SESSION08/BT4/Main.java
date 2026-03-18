package SESSION08.BT4;

public class Main {
    public static void main(String[] args) {
        TemperatureSensor sensor = new TemperatureSensor();
        Fan livingRoomFan = new Fan();
        Humidifier humidifier = new Humidifier();
        System.out.println("them thiet bi");
        sensor.attach(livingRoomFan);
        livingRoomFan.displayRegistration();
        sensor.attach(humidifier);
        humidifier.displayRegistration();
        sensor.setTemperature(18);
        sensor.setTemperature(26);
    }
}
