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

    public setWorkId(int id){
        _id = id;
    }
}

public class Book extends Work {
    private String _author;
    private String _isbn;
    
    public Book(String title, String author, int price, Category categories, String isbn, int numberOfCopies) {
        super(price, numberOfCopies, title, category);
        _author = author;
        _isbn = isbn;
    }
}

public class Dvd extends Work {
    private String _director;
    private String _igac;
    
    public Dvd(String title, String director, int price, Category categories, String igac, int numberOfCopies) {
        super(price, numberOfCopies, title, category);
        _director = director;
        _igac = igac;
    }
}