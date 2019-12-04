package m19.core.Rules;

import m19.core.Works.Work;
import m19.core.Users.User;

public class RulesWraper {
    private Rule currentState;

    public RulesWraper() {
        currentState = new CheckRequestTwice();
    }

    public void set_state(Rule r) {
        currentState = r;
    }

    public int checkRule(User user, Work work) {
        if (currentState == null) return -1; //final
        return currentState.checkRule(this, user, work); // 0 if ok | !=0 returns id of failed rule
    }   
}