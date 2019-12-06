package m19.core.Users;

public interface Behavior {
    public void doBehavior(User user);
    public String toString();
    public int getDeadline(int AvailableCopies);
    public int getMaxRequestPrice();
    public int getMaxRequests();
    public boolean canPayFine();
}