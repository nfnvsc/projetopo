package m19.core.Notifications;

import m19.core.Works.Work;

import java.io.Serializable;

abstract public class Notification implements Serializable{
    
    private Work _work;
    private int _id;
    private static final long serialVersionUID = 201901101348L;

    Notification(Work work, int id){
        _work = work;
    }

    public int getId(){
        return _id;
    }

    public int getWorkId(){
        return _work.getId();
    }

    String writeNotification(){
        return _work.toString();
    }

}