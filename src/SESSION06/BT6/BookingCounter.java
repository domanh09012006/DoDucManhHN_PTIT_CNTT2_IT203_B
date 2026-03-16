package SESSION06.BT6;

public class BookingCounter extends Thread {

    private String name;
    private TicketPool pool;

    public BookingCounter(String name, TicketPool pool) {
        this.name = name;
        this.pool = pool;
    }

    @Override
    public void run() {

        try {

            Ticket ticket = pool.holdTicket(name);

            Thread.sleep(3000);

            if (ticket != null) {
                pool.sellHeldTicket(name, ticket);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
