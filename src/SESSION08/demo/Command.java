package SESSION08.demo;

public class Command {
    public static void main(String[] args) {
        Light light = new Light();
        LightCommand on = new TurnOnLight(light);
        LightCommand off = new TurnOnLight(light);


        RemoteLight remoteLight = new RemoteLight();





    }
}
class Light{
    void turnOn(){
        System.out.println("Bat den");
    }
    void turnOff(){
        System.out.println("Tat den");
    }
}

//lenh
interface LightCommand{
    void execute();
    void undo();
}
class TurnOnLight implements LightCommand{
    private Light light;
    public TurnOnLight(Light light){
        this.light = light;
    }
    @Override
    public void execute(){
        light.turnOff();
    }

    @Override
    public void undo() {
        light.turnOn();
    }

}
class RemoteLight{
    private LightCommand lightCommand;
    private void setLightCommand(LightCommand lightCommand){
        this.lightCommand = lightCommand;
    }
    public void pressPowerButton(){
        lightCommand.execute();
    }
    public void undoPowerButton(){
        lightCommand.undo();
    }
}