package m19.core.Users;

import java.io.Serializable;

public interface Behavior extends Serializable {
    public void doBehavior(User user);
    public String toString();
    public int getDeadline(int AvailableCopies);
    public int getMaxRequestPrice();
    public int getMaxRequests();
    public boolean canPayFine();
}