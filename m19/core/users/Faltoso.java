package m19.core.users;

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
    public int getDeadline(int NumberofCopies) {
        if(NumberofCopies > 0)
            return _deadline;
        return 0;
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
        }
    }    
}