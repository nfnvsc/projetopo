package m19.core;

/*
 * Observer class for users
 */
public class Notification {

    private String _message;


    public Notification(String message) {
        _message = message;
    }

    public String getMessage(){
        return _message;
    }


}