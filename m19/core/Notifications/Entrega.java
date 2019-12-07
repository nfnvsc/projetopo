package m19.core.Notifications;

import m19.core.Works.Work;

public class Entrega extends Notification{

    public Entrega(Work work){
        super(work, 1);
    }

    @Override
    public String writeNotification(){
        return "ENTREGA: " + super.writeNotification();
    }

}