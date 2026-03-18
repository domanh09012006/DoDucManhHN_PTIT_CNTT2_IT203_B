package SESSION08.BT1;

public class LightFactory extends DeviceFactory {

    @Override
    public Device createDevice() {
        return new Light();
    }
}
