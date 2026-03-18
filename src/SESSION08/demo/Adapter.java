package SESSION08.demo;

public class Adapter {
}
class YoungHuman {
    public void move2foot() {
        System.out.println("di = 2 chan");
    }
}
interface OldHuman {
    void move3foot();
}
class HumanAdapter implements OldHuman{
    private YoungHuman old;
    public HumanAdapter(YoungHuman old) {
        this.old = old;
    }
    @Override
    public void move3foot() {
        old.move2foot();
            System.out.println("di = 3 chan");
    }
}
