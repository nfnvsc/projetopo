package m19.core.Users;

import m19.core.*;
import m19.core.exception.BadEntrySpecificationException;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable{

    private int _returns;
    private int _fine;
    private int _id;
    private boolean _isActive;
    private String _name;
    private String _email;
    private List<Request> _requests = new ArrayList<>();
    private List<String> _inbox = new ArrayList<String>();
    private Behavior _userBehavior;
    private static final long serialVersionUID = 201901101347L;


    public User(String name, String email) {
        _name = name;
        _email = email;
        _isActive = true;
        setUserBehavior(new Normal());
    }
    public void clearFine() {
        _fine = 0;
    }
    public int getFine() {
        return _fine;
    }
    public void updateFine(int fine) {
        _fine += fine;
    }
    public void setUserId(int id) {
        _id = id;
    }
    public boolean isActive() {
        return _isActive;
    }
    public String getName(){
        return _name;
    }
    public Behavior getUserBehavior() {
        return _userBehavior;
    }
    public void setUserBehavior(Behavior behavior) {
        this._userBehavior = behavior;
    }
    public int getId(){
        return _id;
    }
    public int getNumberRequests() {
        return _requests.size();
    }
    public List<Request> getRequests() {
        return _requests;
    }
    public String toString() {
        if (_isActive) {
            return String.valueOf(_id) + " - " + _name + " - " + _email +" - " + _userBehavior.toString() + " - " + "ACTIVO";
        } else {
            return String.valueOf(_id) + " - " + _name + " - " + _email + " - " + _userBehavior.toString() + " - " + "SUSPENSO"; //Falta adicionar multa
        }
    }
    public void addUserRequest(Request request) {
        _requests.add(request);
    }
    public void checkState() {
        for (Request r : _requests) {
            if(r.getDeadline() < 0) {
                _isActive = false;
                return;
            }
        }
        _isActive = true;

    }
    public void removeUserRequest(Request request) throws BadEntrySpecificationException {
        if (!(_requests.remove(request))) throw new BadEntrySpecificationException("bese");
    }
    public void addToInbox(String message) {
        _inbox.add(message);
    }
    public void updateReturns(int inTime) {
        if (inTime == 1) {
            _returns++;
        } else {
            _returns--;
        }
    }
    public int getReturns() {
        return _returns;
    }
}