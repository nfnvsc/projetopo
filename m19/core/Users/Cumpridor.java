package m19.core.Users;

public class Cumpridor implements Behavior {
    private final int _maxRequests = 5;
    private static final long serialVersionUID = 201901101348L;

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
    
    public boolean canPayFine() {
        return false;
    }

    public void checkBehavior(UserBehavior currentBehavior, User user) {
        // User pode deixar de ser cumpridor?
    }
}