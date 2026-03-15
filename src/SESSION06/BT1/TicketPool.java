package SESSION06.BT1;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {

    private String roomName;
    private Queue<Ticket> tickets = new LinkedList<>();
    private int nextId = 1;

    public TicketPool(String roomName) {
        this.roomName = roomName;
    }

    public synchronized void addTickets(int count) {

        for (int i = 0; i < count; i++) {
            String id = roomName + "-" + String.format("%03d", nextId++);
            tickets.add(new Ticket(id));
        }

        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);
    }

    public synchronized Ticket sellTicket() {

        if (tickets.isEmpty()) {
            return null;
        }

        return tickets.poll();
    }

    public synchronized int remainingTickets() {
        return tickets.size();
    }
}