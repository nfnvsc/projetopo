package m19.core;

/*
 * Mediator class between Users and Works
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