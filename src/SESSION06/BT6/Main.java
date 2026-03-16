package SESSION06.BT6;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        TicketPool poolA = new TicketPool("A", 3);
        TicketPool poolB = new TicketPool("B", 3);
        TicketPool poolC = new TicketPool("C", 3);

        TimeoutManager manager =
                new TimeoutManager(Arrays.asList(poolA, poolB, poolC));

        manager.start();

        BookingCounter c1 = new BookingCounter("Quầy 1", poolA);
        BookingCounter c2 = new BookingCounter("Quầy 2", poolA);
        BookingCounter c3 = new BookingCounter("Quầy 3", poolA);
        BookingCounter c4 = new BookingCounter("Quầy 4", poolB);
        BookingCounter c5 = new BookingCounter("Quầy 5", poolC);

        c1.start();
        c2.start();
        c3.start();
        c4.start();
        c5.start();
    }
}
