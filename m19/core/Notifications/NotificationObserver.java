package m19.core.Notifications;

import m19.core.Entity;

import java.util.Observable;
import java.util.Observer;


/*
 * Mediator class between Users and Works
 */
public class NotificationObserver implements Observer{

    private Entity _entity;
    private int _id;

    NotificationObserver(Entity entity, Notification notification){
        _entity = entity;
        _id = notification.getId();
    }

    @Override
    public void update(Observable notificationManager, Object input) {
        Notification notification = (Notification) input;
        if(_id == notification.getId()) 
            _entity.addToInbox(notification.writeNotification());
    }
}