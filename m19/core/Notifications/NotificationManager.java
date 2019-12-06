package m19.core.Notifications;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
  
public class NotificationManager extends Observable{
  
    private List<Observer> _observers = new ArrayList<>();

    public void addEvent(Notification notification) {
        notifyObservers(notification);
    }

    public void notifyObservers(Notification notification) {
        for (Observer observer : this._observers) {
            observer.update(this, notification);
        }
    }

    public void registerNotificationObserver(Observer observer) {
        _observers.add(observer);
    }
}