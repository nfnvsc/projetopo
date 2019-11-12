package m19.core;

import java.util.ArrayList;

import com.sun.nio.sctp.Notification;

public class User {
    private enum UserBehavior {
        NORMAL, CUMPRIDOR, FALTOSO;
    }
    private int _id;
    private boolean _isActive;
    private String _name;
    private String _email;
    private ArrayList<Notification> _notifications = new ArrayList<Notification>();
    private UserBehavior _userDescription;

    public User(String name, String email) {
        _name = name;
        _email = email;
        _isActive = true;
    }
    public void setUserId(int id) {
        _id = id;
    }
    protected boolean isActive() {
        return _isActive;
    }
    public UserBehavior getDescription() {
        return _userDescription;
    }
    public void setUserDescription(UserBehavior userDescription) {
        _userDescription = userDescription;
    }
    protected ArrayList<Notification> getNotifications() {
        return _notifications;
    }
}