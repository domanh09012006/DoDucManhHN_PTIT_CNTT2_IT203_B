package SESSION06.BT1.BT2;

import java.util.Random;

public class BookingCounter implements Runnable {

    String counterName;
    TicketPool roomA;
    TicketPool roomB;
    int soldCount = 0;
    Random random = new Random();
    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
    }
    public void run() {
        while (true) {
            if (roomA.remainingTickets() == 0 && roomB.remainingTickets() == 0) {
                break;
            }
            Ticket ticket;
            if (random.nextBoolean()) {
                ticket = roomA.sellTicket();
            } else {
                ticket = roomB.sellTicket();
            }
            if (ticket != null) {
                soldCount++;
                System.out.println(counterName + " đã bán vé " + ticket.ticketId);
            }
            try {
                Thread.sleep(200);
            } catch (Exception e) {}
        }
    }
}
