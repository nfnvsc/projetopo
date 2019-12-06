package m19.core.Notifications;

import m19.core.Works.Work;

public class Entrega implements Notification{
    
    private Work _work;
    private int _id = 1;

    public Entrega(Work work){
        _work = work;
    }

    public String writeNotification(){
        return "ENTREGA: " + _work.toString();
    }

    public int getId(){
        return _id;
    }

    public int getWorkId(){
        return _work.getId();
    }
}