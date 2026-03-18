package SESSION08.demo;

import java.util.ArrayList;
import java.util.List;

public class Observer {
}
interface ReceiverObserver{
    void update(String news);
}
class SourceNews{
    private List<ReceiverObserver> observers = new ArrayList<>();
    public void addReceiver(ReceiverObserver receiver){
        observers.add(receiver);
    }
    public  void sendNews(){
        String content = "Bình ăn cứt";
        observers.forEach(ob -> {
            ob.update(content);
        });
    }

}
class ConcerteReceiver{
    private String name;
    ConcerteReceiver(String name){
        this.name = name;
    }
    void
}
