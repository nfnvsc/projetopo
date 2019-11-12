public class Dvd extends Work {
    private String _director;
    private String _igac;

    public Dvd(String title, String director, int price, Category categories, String igac, int numberOfCopies) {
        super(price, numberOfCopies, title, category);
        _director = director;
        _igac = igac;
    }
}