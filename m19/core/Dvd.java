package m19.core;

public class Dvd extends Work {
    private String _director;
    private String _igac;

    public Dvd(String title, String director, int price, Category category, String igac, int numberOfCopies) {
        super(price, numberOfCopies, title, category);
        _director = director;
        _igac = igac;
    }
    
    @Override
    public String toString(){
        return super.toString() + " - " + _director + " - " + _igac;
    }
}