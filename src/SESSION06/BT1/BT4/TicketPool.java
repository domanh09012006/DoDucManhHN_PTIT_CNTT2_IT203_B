package SESSION06.BT1.BT4;

import java.util.LinkedList;
import java.util.Queue;

public class TicketPool {
    String roomName;
    Queue<Ticket> tickets = new LinkedList<>();
    int nextId = 1;
    public TicketPool(String roomName, int count) {
        this.roomName = roomName;
        for (int i = 0; i < count; i++) {
            String id = roomName + "-" + String.format("%03d", nextId++);
            tickets.add(new Ticket(id, roomName));
        }
    }
    public synchronized Ticket sellTicket() {
        while (tickets.isEmpty()) {
            System.out.println("Hết vé phòng " + roomName + ", đang chờ...");
            try {
                wait();
            } catch (InterruptedException e) {}
        }
        return tickets.poll();
    }
    public synchronized void addTickets(int count) {
        for (int i = 0; i < count; i++) {
            String id = roomName + "-" + String.format("%03d", nextId++);
            tickets.add(new Ticket(id, roomName));
        }
        System.out.println("Nhà cung cấp: Đã thêm " + count + " vé vào phòng " + roomName);
        notifyAll();
    }
}
