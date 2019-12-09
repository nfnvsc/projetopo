package m19.core.notifications;

import m19.core.works.Work;

public class Devolucao extends Notification{

    public Devolucao(Work work){
        super(work, 1);
    }

    @Override
    public String writeNotification(){
        return "ENTREGA: " + super.writeNotification();
    }

}