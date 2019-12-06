package m19.core.Notifications;

import m19.core.Works.Work;

public class Requisicao extends Notification{
    
    public Requisicao(Work work){
        super(work, 2);
    }

    @Override
    public String writeNotification(){
        return "REQUISICÃO: " + super.writeNotification();
    }

}