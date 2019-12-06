import m19.core.Works.Work;

public class Entrega implements Notification{
    
    private Work _work;

    Entrega(Work work){
        _work = work;
    }

    public String writeNotification(){
        return "ENTREGA: " + _work.toString();
    }

    public int getId(){
        return _work.getId();
    }
}