package m19.core;

import java.io.Serializable;

abstract class Work implements Serializable {

    private int _id;
    private int _price;
    private int _numberOfCopies;
    private int _copiesAvaliable;
    private String _title;
    private Category _category;
    private static final long serialVersionUID = 201901101346L;

    public Work(int price, int numberOfCopies, String title, Category category) {
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

    abstract String searchTerm();

}
