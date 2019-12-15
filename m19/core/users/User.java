package m19.core.users;

import m19.core.*;
import m19.app.exception.WorkNotBorrowedByUserException;

import java.util.ArrayList;
import java.util.List;

public class User extends Entity{

    private int _returns;
    private int _fine;
    private int _id;
    private boolean _isActive;
    private String _name;
    private String _email;
    private List<Request> _requests = new ArrayList<>();
    private UserBehavior _userBehavior;
    private static final long serialVersionUID = 201901101347L;

    public User(String name, String email) {
        _name = name;
        _email = email;
        _isActive = true;
        _userBehavior = new UserBehavior();
    }
    public int getFine() {
        return _fine;
    }
    public void clearFine() {
        _fine = 0;
    }

    public void updateFine(int fine) {
        _fine += fine;
        _isActive = false;
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
        return _userBehavior.getCurrentBehavior();
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
            return String.valueOf(_id) + " - " + _name + " - " + _email +" - " + _userBehavior.getCurrentBehavior().toString() + " - " + "ACTIVO";
        } else {
            return String.valueOf(_id) + "  - " + _name + " - " + _email + " - " + _userBehavior.getCurrentBehavior().toString() + " - " + "SUSPENSO - EUR " + String.valueOf(_fine);
        }
    }
    public void addUserRequest(Request request) {
        _requests.add(request);
    }
    public void checkState(int date) {
        if (_fine > 0){
            _isActive = false;
            return;
        } 
        
        for (Request r : _requests) {
            if(r.getDeadline() < date) {
                _isActive = false;
                return;
            }
        }
        _isActive = true;

    }

    public int removeUserRequest(Request request, int date) throws WorkNotBorrowedByUserException {
        Request userRequest;
        if ((userRequest = checkRequest(request.getWork().getId())) == null) throw new WorkNotBorrowedByUserException(request.getWork().getId(), _id);
        _requests.remove(userRequest);
        int inTime = date - userRequest.getDeadline();
        updateReturns(inTime);
        checkState(date);
        checkBehavior();
        return userRequest.getDeadline();
    }

    public void updateReturns(int inTime) {
        if (inTime < 0) {
            if (_returns < 0) resetLastReturns();
            _returns++;
        } else {
            if (_returns > 0) resetLastReturns();
            _returns--;
        }
    }
    public int getLastReturns() {
        return _returns;
    }
    public void resetLastReturns() {
        _returns = 0;
    }
    public void checkBehavior() {
        _userBehavior.checkBehavior(this);
    }

    public Request checkRequest(int workId){
        for(Request request : _requests){
            if(request.getWork().getId() == workId) return request;
        }
        return null;
    }

    
    
}