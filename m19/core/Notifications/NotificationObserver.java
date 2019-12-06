package m19.core.Notifications;

import m19.core.Entity;

import java.io.Serializable;
import java.util.Observable;
import java.util.Observer;

/*
 * Mediator class between Users and Works
 */
public class NotificationObserver implements Observer, Serializable{

    private Entity _entity;
    private Notification _notification;
    private static final long serialVersionUID = 201901101348L;

    public NotificationObserver(Entity entity, Notification notification){
        _entity = entity;
        _notification = notification;
    }

    @Override
    public void update(Observable notificationManager, Object input) {
        Notification notificationReceived = (Notification) input;
        if(_notification.getId() == notificationReceived.getId() && _notification.getWorkId() == notificationReceived.getWorkId()) 
            _entity.addToInbox(_notification.writeNotification());
    }
}