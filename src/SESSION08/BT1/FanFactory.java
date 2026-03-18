package SESSION08.BT1;

public class FanFactory extends DeviceFactory {
    @Override
    public Device createDevice() {
        return new Fan();
    }
}