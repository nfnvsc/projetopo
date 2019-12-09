package m19.core.notifications;

import m19.core.works.Work;

import java.io.Serializable;

import java.util.Objects;

abstract public class Notification implements Serializable{
    
    private Work _work;
    private final int _id;
    private static final long serialVersionUID = 201901101348L;

    Notification(Work work, int id){
        _work = work;
        _id = id;
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

    @Override
    public boolean equals(Object o) { 
        if (o == this) return true; 
  
        if (!(o instanceof Notification)) return false; 
          
        Notification c = (Notification) o; 
          
        return c.getId() == this.getId() && c.getWorkId() == this.getWorkId();

    }

    @Override
    public int hashCode(){
        return Objects.hash(_work, _id);
    }
}