package m19.core.Users;

public class Cumpridor implements Behavior {
    private final int _maxRequests = 5;

    public void doBehavior(User user) {
        user.setUserBehavior(this);
    }
    public String toString() {
        return "CUMPRIDOR";
    }
    public int getMaxRequests() {
        return _maxRequests;
    }
    public int getMaxRequestPrice() {
        return -1;
    }
    public int getDeadline(int AvailableCopies) {
        if (AvailableCopies == 1) {
            return 8;
        }
        else if (AvailableCopies <= 5) {
            return 15;
        }
        else {
            return 30;
        }
    }
}