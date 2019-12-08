package m19.core.Users;

public class Faltoso implements Behavior {
    private final int _maxRequests = 1;
    private final int _deadline = 2;
    private static final long serialVersionUID = 201901101348L;

    public String toString() {
        return "FALTOSO";
    }
    public int getMaxRequests() {
        return _maxRequests;
    }   
    public int getDeadline(int AvailableCopies) {
        return _deadline;
    }
    public int getMaxRequestPrice() {
        return 25;
    }
    public boolean canPayFine() {
        return true;
    }
    
    public void checkBehavior(UserBehavior currentBehavior, User user) {
        if (user.getLastReturns() == 3) {
            currentBehavior.setBehavior(new Normal());
            user.resetLastReturns();
        }
    }    
}