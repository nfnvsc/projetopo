package m19.core;
import java.io.Serializable;

import m19.core.Users.User;


import m19.core.Works.*;

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
    public void setDeadline(int deadline) {
        _deadline = deadline;
    }
    public void updateDeadline(int daysAdvanced) {
        _deadline -= daysAdvanced;
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