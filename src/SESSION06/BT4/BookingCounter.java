package SESSION06.BT4;

public class BookingCounter implements Runnable {
    String counterName;
    TicketPool pool;
    public BookingCounter(String counterName, TicketPool pool) {
        this.counterName = counterName;
        this.pool = pool;
    }
    public void run() {
        while (true) {
            Ticket t = pool.sellTicket();
            System.out.println(counterName + " bán vé " + t.ticketId);
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
        }
    }
}