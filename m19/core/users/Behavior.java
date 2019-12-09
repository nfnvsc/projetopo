package m19.core.users;

import java.io.Serializable;

public interface Behavior extends Serializable {
    public String toString();
    public int getDeadline(int AvailableCopies);
    public int getMaxRequestPrice();
    public int getMaxRequests();
    public boolean canPayFine();
    public void checkBehavior(UserBehavior currentBehavior, User user);
}