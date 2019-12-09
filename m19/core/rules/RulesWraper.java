package m19.core.rules;

import m19.core.works.Work;
import m19.core.users.User;

public class RulesWraper {
    private Rule _currentState;
    private User _user;
    private Work _work;

    public RulesWraper(User user, Work work) {
        _currentState = new CheckRequestTwice();
        _work = work;
        _user = user;
    }

    public void set_state(Rule r) {
        _currentState = r;
    }

    public User getUser(){
        return _user;
    }
    public Work getWork(){
        return _work;
    }
    public int checkRule() {
        if (_currentState == null) return -1; //final
        return _currentState.checkRule(this); // 0 if ok | !=0 returns id of failed rule
    }   
}