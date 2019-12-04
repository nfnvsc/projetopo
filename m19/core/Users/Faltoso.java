package m19.core.Users;

public class Faltoso implements Behavior {
    private final int _maxRequests = 1;
    private final int _deadline = 2;

    public void doBehavior(User user) {
        user.setUserBehavior(this);
    }
    public String toString(){
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
}