package m19.core;

public class Book extends Work {
    private String _author;
    private String _isbn;

    public Book(String title, String author, int price, Category category, String isbn, int numberOfCopies) {
        super(price, numberOfCopies, title, category);
        _author = author;
        _isbn = isbn;
    }
    
    public String searchTerms(){
        //por fazer
        return "";
    }

    @Override
    public String toString(){
        return super.toString("BOOK") + " - " + _author + " - " + _isbn;
    }
}