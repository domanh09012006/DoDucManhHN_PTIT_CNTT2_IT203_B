package SESSION06.BT6;

import java.util.ArrayList;
import java.util.List;

public class TicketPool {

    private String roomName;
    private List<Ticket> tickets = new ArrayList<>();

    public TicketPool(String roomName, int capacity) {

        this.roomName = roomName;

        for (int i = 1; i <= capacity; i++) {
            tickets.add(new Ticket(roomName + "-" + String.format("%03d", i)));
        }
    }

    public synchronized Ticket holdTicket(String counterName) {

        for (Ticket t : tickets) {

            if (!t.isHeld() && !t.isSold()) {

                t.setHeld(true);
                t.setHoldExpiryTime(System.currentTimeMillis() + 5000);

                System.out.println(counterName +
                        ": Đã giữ vé " + t.getId() +
                        ". Vui lòng thanh toán trong 5s");

                return t;
            }
        }

        return null;
    }

    public synchronized void sellHeldTicket(String counterName, Ticket ticket) {

        if (ticket != null && ticket.isHeld()) {

            ticket.setSold(true);
            ticket.setHeld(false);

            System.out.println(counterName +
                    ": Thanh toán thành công vé " + ticket.getId());
        }
    }

    public synchronized void releaseExpiredTickets() {

        long now = System.currentTimeMillis();

        for (Ticket t : tickets) {

            if (t.isHeld() && !t.isSold() && now > t.getHoldExpiryTime()) {

                t.setHeld(false);

                System.out.println(
                        "TimeoutManager: Vé " +
                                t.getId() +
                                " hết hạn giữ, đã trả lại kho"
                );
            }
        }
    }
}