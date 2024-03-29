package m19.core.notifications;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
  
public class NotificationManager extends Observable implements Serializable{
  
    private List<Observer> _observers = new ArrayList<>();
    private static final long serialVersionUID = 201901101348L;

    public void notifyObservers(Notification notification) {
        for (Observer observer : this._observers) {
            observer.update(this, notification);
        }
    }

    public void registerNotificationObserver(Observer observer) {
        _observers.add(observer);
    }

    public void removeNotificationObserver(int entityId, int workId){
        Iterator itr = _observers.iterator(); 
        while (itr.hasNext()) 
        { 
            NotificationObserver no = (NotificationObserver)itr.next(); 
            if (no.isEqual(entityId, workId)){
                itr.remove(); 
            }
        } 

    }

    
}