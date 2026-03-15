package SESSION06.BT1;

public class Main {
    public static void main(String[] args) {
        TicketPool roomA = new TicketPool("A");
        TicketPool roomB = new TicketPool("B");
        roomA.addTickets(5);
        roomB.addTickets(5);
        Thread counter1 = new Thread(new BookingCounter("Quầy 1", roomA));
        Thread counter2 = new Thread(new BookingCounter("Quầy 2", roomB));
        Thread supplier = new Thread(
                new TicketSupplier(roomA, roomB, 3, 3000, 3)
        );
        counter1.start();
        counter2.start();
        supplier.start();
    }
}