package m19.core;

public class Book extends Work {
    private String _author;
    private String _isbn;

    public Book(String title, String author, int price, Category category, String isbn, int numberOfCopies) {
        super(price, numberOfCopies, title, category);
        _author = author;
        _isbn = isbn;
    }
    
    public String searchTerm(){
        return _author + " " + super.getTitle();
    }

    @Override
    public String toString(){
        return super.toString("Livro") + " - " + _author + " - " + _isbn;
    }
}