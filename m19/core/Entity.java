package m19.core;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

abstract public class Entity implements Serializable{
    private int _id;
    private List<String> _inbox = new ArrayList<String>();
    private static final long serialVersionUID = 201901101347L;

    public int getId(){
        return _id;
    }

    public void setId(int id){
        _id = id;
    }

    public void addToInbox(String message){
        _inbox.add(message);
    }

    public String checkInbox(){
        String outString = "";
  
        for(String message : _inbox) { 
            outString += message + "\n"; 
        }

        _inbox.clear();

        return outString;
    }
}