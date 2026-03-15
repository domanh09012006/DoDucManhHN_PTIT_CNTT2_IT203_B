package SESSION06.BT1.BT3;

public class BookingCounter implements Runnable {
    String counterName;
    TicketPool roomA;
    TicketPool roomB;
    boolean reverse;
    public BookingCounter(String counterName, TicketPool roomA, TicketPool roomB, boolean reverse) {
        this.counterName = counterName;
        this.roomA = roomA;
        this.roomB = roomB;
        this.reverse = reverse;
    }
    public void sellCombo() {
        TicketPool first = reverse ? roomB : roomA;
        TicketPool second = reverse ? roomA : roomB;
        synchronized (first) {
            Ticket t1 = first.getTicket();
            if (t1 != null) {
                System.out.println(counterName + ": Đã lấy vé " + t1.ticketId);
            }
            try {
                Thread.sleep(500);
            } catch (Exception e) {}
            System.out.println(counterName + ": Đang chờ vé " + second.roomName);
            synchronized (second) {
                Ticket t2 = second.getTicket();
                if (t1 != null && t2 != null) {
                    System.out.println(counterName +
                            " bán combo thành công: "
                            + t1.ticketId + " & " + t2.ticketId);
                } else {
                    System.out.println(counterName + ": Bán combo thất bại");
                }
            }
        }
    }
    public void run() {
        while (true) {
            sellCombo();
        }
    }
}