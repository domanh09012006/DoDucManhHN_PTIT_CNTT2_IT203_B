package SESSION08.BT3;

public class Main {
    public static void main(String[] args) {
        Light livingRoomLight = new Light();
        AirConditioner myAC = new AirConditioner();
        RemoteControl remote = new RemoteControl(5);
        remote.setCommand(0, new LightOnCommand(livingRoomLight));
        System.out.print("Nhấn nút 1: ");
        remote.pressButton(0);

        remote.setCommand(1, new LightOffCommand(livingRoomLight));
        System.out.print("Nhấn nút 2: ");
        remote.pressButton(1);
        System.out.print("Nhấn Undo: ");
        remote.pressUndo();
        System.out.println("--------------------");
        remote.setCommand(2, new ACSetTemperatureCommand(myAC, 26));
        System.out.print("Nhấn nút 3: ");
        remote.pressButton(2);
        System.out.print("Nhấn Undo: ");
        remote.pressUndo();
    }
}
