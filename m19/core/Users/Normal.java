package m19.core.Users;

public class Normal implements Behavior {
    private final int _maxRequests = 3;
    public void doBehavior(User user) {
        user.setUserBehavior(this);
    }

    public String toString() {
        return "NORMAL";
    }
    public int getMaxRequests() {
        return _maxRequests;
    }
    public int getDeadline(int AvailableCopies) {
        if (AvailableCopies == 1) {
            return 3;
        } else if (AvailableCopies <= 5) {
            return 8;
        } else {
            return 15;
        }
    }
    public int getMaxRequestPrice() {
        return 25;
    }
    public boolean canPayFine() {
        return false;
    }
}