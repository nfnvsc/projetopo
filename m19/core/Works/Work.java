package m19.core.Works;

import m19.core.Request;
import java.io.Serializable;

import java.util.List;
import java.util.ArrayList;

abstract public class Work implements Serializable {

    private List<Request> _requests = new ArrayList<>();
    private int _id;
    private int _price;
    private int _numberOfCopies;
    private int _copiesAvaliable;
    private String _title;
    private Category _category;
    private static final long serialVersionUID = 201901101346L;

    Work(int price, int numberOfCopies, String title, Category category) {
        _price = price;
        _numberOfCopies = numberOfCopies;
        _copiesAvaliable = numberOfCopies;
        _title = title;
        _category = category;
    }

    public String toString(String type){
        return String.valueOf(_id) +  " - " + _copiesAvaliable + " de " + _numberOfCopies + " - " + type + " - " + _title + " - " + String.valueOf(_price) + " - " +  _category.getDescription();
    }

    
    public void setWorkId(int id){
        _id = id;
    }

    public int getId(){
        return _id;
    }

    public String getTitle(){
        return _title;
    }

    public int getAvaliableCopies(){
        return _copiesAvaliable; 
    }

    public Category getCategory(){
        return _category;
    }

    public void decrementCopiesAvaliable(){
        _copiesAvaliable--;
    }

    public int getPrice(){
        return _price;
    }
    
    public void addRequest(Request request) {
        _requests.add(request);
        _copiesAvaliable--;
    }
    
    abstract public String searchTerm();

}
