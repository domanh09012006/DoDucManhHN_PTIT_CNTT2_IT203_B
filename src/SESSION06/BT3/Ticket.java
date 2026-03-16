package SESSION06.BT3;

public class Ticket {
    String ticketId;
    String roomName;
    boolean isSold;
    public Ticket(String ticketId, String roomName) {
        this.ticketId = ticketId;
        this.roomName = roomName;
        this.isSold = false;
    }
}