package m19.core;

public class Book extends Work {
    private String _author;
    private String _isbn;

    public Book(String title, String author, int price, Category categories, String isbn, int numberOfCopies) {
        super(price, numberOfCopies, title, category);
        _author = author;
        _isbn = isbn;
    }
}