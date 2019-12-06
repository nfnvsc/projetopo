package m19.core.Users;

import m19.core.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class User implements Serializable, Entity{

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
        _userBehavior = null;
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
    protected List<Notification> getNotifications() {
        return _notifications;
    }
    public int getId(){
        return _id;
    }
    public int getNumberRequests() {
        return _requests.size();
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

    public void addToInbox(String message){
        _inbox.add(message);
    }
}