package m19.core.Notifications;

import m19.core.Works.Work;

public class Requisicao implements Notification{

    private Work _work;
    private int _id = 2;

    public Requisicao(Work work){
        _work = work;
    }

    public String writeNotification(){
        return "REQUISICÃO: " + _work.toString();
    }

    public int getId(){
        return _id;
    }

    public int getWorkId(){
        return _work.getId();
    }
}