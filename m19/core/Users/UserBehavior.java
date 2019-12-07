package m19.core.Users;

import m19.core.Users.User;

public class UserBehavior {
    private Behavior currentBehavior;

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