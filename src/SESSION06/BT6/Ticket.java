package SESSION06.BT6;

public class Ticket {

    private String id;
    private boolean isHeld;
    private boolean isSold;
    private long holdExpiryTime;

    public Ticket(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public boolean isHeld() {
        return isHeld;
    }

    public void setHeld(boolean held) {
        isHeld = held;
    }

    public boolean isSold() {
        return isSold;
    }

    public void setSold(boolean sold) {
        isSold = sold;
    }

    public long getHoldExpiryTime() {
        return holdExpiryTime;
    }

    public void setHoldExpiryTime(long holdExpiryTime) {
        this.holdExpiryTime = holdExpiryTime;
    }
}
