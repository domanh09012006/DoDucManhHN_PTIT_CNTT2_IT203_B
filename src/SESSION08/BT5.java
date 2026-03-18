package SESSION08;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface Observer {
    void update(int temperature);
}

interface Subject {
    void attach(Observer o);
    void notifyObservers();
}

interface Command {
    void execute();
}

class Light {
    public void off() {
        System.out.println("Den: Tat");
    }
}

class Fan implements Observer {
    public void setLow() {
        System.out.println("Quat: Dang chay o toc do thap");
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            System.out.println(">>> Quat (Tu dong): Phat hien nhiet do cao (" + temperature + "°C) -> Chuyen sang TOC DO MANH!");
        }
    }
}

class AirConditioner implements Observer {
    private int currentTemp = 25;

    public void setTemp(int t) {
        this.currentTemp = t;
        System.out.println("Dieu hoa: Da set nhiet do = " + currentTemp + "°C");
    }

    @Override
    public void update(int temperature) {
        if (temperature > 30) {
            System.out.println(">>> Dieu hoa (Tu dong): Dang duy tri lam mat toi uu cho phong " + temperature + "°C");
        }
    }
}

class TemperatureSensor implements Subject {
    private List<Observer> observers = new ArrayList<>();
    private int temperature;

    public void setTemperature(int temp) {
        this.temperature = temp;
        System.out.println("\n[Cam bien]: Nhiet do hien tai thay doi thanh " + temp + "°C");
        notifyObservers();
    }

    @Override
    public void attach(Observer o) {
        observers.add(o);
    }

    @Override
    public void notifyObservers() {
        for (Observer o : observers) {
            o.update(temperature);
        }
    }
}

class SleepModeCommand implements Command {
    private Light light;
    private AirConditioner ac;
    private Fan fan;

    public SleepModeCommand(Light l, AirConditioner a, Fan f) {
        this.light = l;
        this.ac = a;
        this.fan = f;
    }

    @Override
    public void execute() {
        System.out.println("\n--- KICH HOAT CHE DO NGU THONG MINH ---");
        System.out.print("SleepMode thuc thi: ");
        light.off();
        System.out.print("SleepMode thuc thi: ");
        ac.setTemp(28);
        System.out.print("SleepMode thuc thi: ");
        fan.setLow();
        System.out.println("--------------------------------------");
    }
}

public class BT5 {
    public static void main(String[] args) {
        Light roomLight = new Light();
        Fan roomFan = new Fan();
        AirConditioner roomAC = new AirConditioner();
        TemperatureSensor sensor = new TemperatureSensor();

        sensor.attach(roomFan);
        sensor.attach(roomAC);

        Command sleepMode = new SleepModeCommand(roomLight, roomAC, roomFan);

        Scanner sc = new Scanner(System.in);
        int choice;

        System.out.println("He thong Session 09 san sang.");

        do {
            System.out.println("\n--- MENU DIEU KHIEN ---");
            System.out.println("1. Nhan nut 'Ngu' (Sleep Mode)");
            System.out.println("2. Gia lap nhiet do tang (32 do)");
            System.out.println("3. Gia lap nhiet do binh thuong (24 do)");
            System.out.println("0. Thoat");
            System.out.print("Chon thao tac: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sleepMode.execute();
                    break;
                case 2:
                    sensor.setTemperature(32);
                    break;
                case 3:
                    sensor.setTemperature(24);
                    break;
                case 0:
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon khong hop le.");
            }
        } while (choice != 0);
    }
}
