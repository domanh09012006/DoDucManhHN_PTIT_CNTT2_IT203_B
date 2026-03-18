package SESSION08.BT3;

public class ACSetTemperatureCommand implements Command {
    private AirConditioner ac;
    private int prevTemperature;
    private int newTemperature;
    public ACSetTemperatureCommand(AirConditioner ac, int newTemp) {
        this.ac = ac;
        this.newTemperature = newTemp;
    }
    @Override
    public void execute() {
        prevTemperature = ac.getTemperature();
        ac.setTemperature(newTemperature);
    }
    @Override
    public void undo() {
        System.out.print("Undo: ");
        ac.setTemperature(prevTemperature);
    }
}
