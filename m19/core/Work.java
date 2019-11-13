package m19.core;


abstract class Work {

    private int _id;
    private int _price;
    private int _numberOfCopies;
    private String _title;
    private Category _category;

   /* public String getDescription() {
        return 
    }*/

    public Work(int price, int numberOfCopies, String title, Category category) {
        _price = price;
        _numberOfCopies = numberOfCopies;
        _title = title;
        _category = category;
    }

    public String toString(){
        return String.valueOf(_id) +  " - " + String.valueOf(_price) + " - " + String.valueOf(_numberOfCopies) + " - " + _title + " - " + _category;
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
