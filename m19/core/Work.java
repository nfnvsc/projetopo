package m19.core;

import java.util.ArrayList;
import java.util.Locale.Category;

abstract class Work {
    private enum Category {
        REFERENCE, FICTION, SCITECH;
    }
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

    public void setWorkId(int id){
        _id = id;
    }
}