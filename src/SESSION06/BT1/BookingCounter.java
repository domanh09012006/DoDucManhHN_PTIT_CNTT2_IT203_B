package SESSION06.BT1;

public class BookingCounter implements Runnable {
    private String name;
    private TicketPool pool;
    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }
    @Override
    public void run() {
        while (true) {
            Ticket t = pool.sellTicket();
            if (t != null) {
                System.out.println(name + " đã bán vé " + t.getId());
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {
            }
        }
    }
}
