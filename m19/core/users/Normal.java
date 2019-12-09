package m19.core.users;

public class Normal implements Behavior {
    private final int _maxRequests = 3;
    private static final long serialVersionUID = 201901101348L;
    
    public String toString() {
        return "NORMAL";
    }
    public int getMaxRequests() {
        return _maxRequests;
    }
    public int getDeadline(int NumberofCopies) {
        if (NumberofCopies > 0) {
            if (NumberofCopies == 1) {
                return 3;
            } else if (NumberofCopies <= 5) {
                return 8;
            } else {
                return 15;
            }
        }
        return 0;
    }
    public int getMaxRequestPrice() {
        return 25;
    }
    public boolean canPayFine() {
        return false;
    }
    public void checkBehavior(UserBehavior currentBehavior, User user) {
        if (user.getLastReturns() == -3) {
            currentBehavior.setBehavior(new Faltoso());
            user.resetLastReturns();
        } else if (user.getLastReturns() == 5) {
            currentBehavior.setBehavior(new Cumpridor());
            user.resetLastReturns();
        }
    }
}