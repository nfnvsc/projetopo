package m19.core.notifications;

import m19.core.works.Work;

public class Requisicao extends Notification{
    
    public Requisicao(Work work){
        super(work, 2);
    }

    @Override
    public String writeNotification(){
        return "REQUISICÃO: " + super.writeNotification();
    }

}