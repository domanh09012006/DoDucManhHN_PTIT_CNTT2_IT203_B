package SESSION06.BT1.BT4;

public class TicketSupplier implements Runnable {
    TicketPool pool;
    public TicketSupplier(TicketPool pool) {
        this.pool = pool;
    }
    public void run() {
        while (true) {
            try {
                Thread.sleep(3000);
            } catch (Exception e) {}
            pool.addTickets(3);
        }
    }
}