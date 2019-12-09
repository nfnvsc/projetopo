package m19.core.users;

import m19.core.users.User;

import java.io.Serializable;

public class UserBehavior implements Serializable{
    private Behavior currentBehavior;
    private static final long serialVersionUID = 201901101348L;

    public UserBehavior() {
        currentBehavior = new Normal();
    }

    public void setBehavior(Behavior behavior) {
        currentBehavior = behavior;
    }

    public Behavior getCurrentBehavior() {
        return currentBehavior;
    }
    public void checkBehavior(User user) {
        currentBehavior.checkBehavior(this, user);
    }
}