package m19.core;
import java.io.Serializable;

import m19.core.users.User;


import m19.core.works.*;

/*
 * Mediator class between Users and Works
 */
public class Request implements Serializable {
    
    private int _deadline; 
    private User _user;
    private Work _work;
    private static final long serialVersionUID = 201901101348L;

    public Request(User user, Work work) {
        _user = user;
        _work = work;
    }
    public void setDeadline(int deadline, int date) {
        _deadline = deadline + date;
    }
    public User getUser() {
        return _user;
    }
    public Work getWork() {
        return _work;
    }
    public int getDeadline() {
        return _deadline;
    }
}