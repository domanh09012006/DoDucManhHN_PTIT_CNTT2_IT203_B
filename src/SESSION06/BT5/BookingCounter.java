package SESSION06.BT5;

import java.util.ArrayList;
import java.util.Random;

public class BookingCounter implements Runnable {

    String name;
    ArrayList<CinemaRoom> rooms;

    boolean running = true;
    boolean paused = false;

    public BookingCounter(String name, ArrayList<CinemaRoom> rooms) {
        this.name = name;
        this.rooms = rooms;
    }

    public void run() {

        Random random = new Random();

        System.out.println(name + " bắt đầu bán vé...");

        while (running) {

            if (paused) {
                continue;
            }

            CinemaRoom room = rooms.get(random.nextInt(rooms.size()));

            Ticket t = room.sellTicket();

            if (t != null) {
                System.out.println(name + " bán vé " + t.id);
            }

            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}
