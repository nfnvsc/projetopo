package m19.core;


abstract class Work {

    private int _id;
    private int _price;
    private int _numberOfCopies;
    private int _copiesAvaliable;
    private String _title;
    private Category _category;

   /* public String getDescription() {
        return 
    }*/

    public Work(int price, int numberOfCopies, String title, Category category) {
        _price = price;
        _numberOfCopies = numberOfCopies;
        _copiesAvaliable = numberOfCopies;
        _title = title;
        _category = category;
    }

    public String toString(String type){
        return String.valueOf(_id) +  " - " + _copiesAvaliable + " of " + _numberOfCopies + " - " + type + " - " + _title + " - " + String.valueOf(_price) + " - " +  _category;
    }

    
    public void setWorkId(int id){
        _id = id;
    }

    public int getId(){
        return _id;
    }
/*
    public int getId(){
        return _id;
    }

    public int getPrice(){
        return _price;
    }

    public int getNumberOfCopies(){
        return _numberOfCopies;
    }

    public String getTitle(){
        return _title;
    }

    public Category getCategory(){
        return _category;
    }
    */

}
