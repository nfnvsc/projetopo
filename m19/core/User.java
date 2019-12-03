package m19.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.sun.nio.sctp.Notification;

public class User implements Serializable{
    public enum UserBehavior {
        NORMAL, CUMPRIDOR, FALTOSO;
    }
    private int _id;
    private boolean _isActive;
    private String _name;
    private String _email;
    private List<Notification> _notifications = new ArrayList<Notification>();
    private UserBehavior _userDescription;
    private static final long serialVersionUID = 201901101347L;


    public User(String name, String email) {
        _name = name;
        _email = email;
        _isActive = true;
        _userDescription = UserBehavior.NORMAL;
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
    public UserBehavior getDescription() {
        return _userDescription;
    }
    public void setUserDescription(UserBehavior userDescription) {
        _userDescription = userDescription;
    }
    protected List<Notification> getNotifications() {
        return _notifications;
    }
    public int getId(){
        return _id;
    }
    public String toString() {
        if (_isActive) {
            return String.valueOf(_id) + " - " + _name + " - " + _email +" - " + _userDescription + " - " + "ACTIVO";
        } else {
            return String.valueOf(_id) + " - " + _name + " - " + _email + " - " + _userDescription + " - " + "SUSPENSO"; //Falta adicionar multa
        }
    }
}