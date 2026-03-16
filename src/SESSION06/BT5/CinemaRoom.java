package SESSION06.BT5;
import java.util.ArrayList;

public class CinemaRoom {

    String name;
    ArrayList<Ticket> tickets = new ArrayList<>();
    int nextId = 1;

    public CinemaRoom(String name, int count) {

        this.name = name;

        for (int i = 0; i < count; i++) {
            addTicket();
        }
    }

    public synchronized Ticket sellTicket() {

        for (Ticket t : tickets) {

            if (!t.sold) {
                t.sold = true;
                return t;
            }
        }

        return null;
    }

    public synchronized void addTicket() {

        Ticket t = new Ticket(name + "-" + nextId);
        nextId++;

        tickets.add(t);
    }

    public int soldCount() {

        int c = 0;

        for (Ticket t : tickets) {
            if (t.sold) c++;
        }

        return c;
    }
}
