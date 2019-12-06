package m19.core.Notifications;

import java.io.Serializable;

public interface Notification extends Serializable{
    
    public String writeNotification();
    public int getId();
    public int getWorkId();
}