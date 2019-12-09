package m19.core.works;

public class Dvd extends Work {
    private String _director;
    private String _igac;
    private static final long serialVersionUID = 201901101346L;

    public Dvd(String title, String director, int price, Category category, String igac, int numberOfCopies) {
        super(price, numberOfCopies, title, category);
        _director = director;
        _igac = igac;
    }
    
    public String searchTerm(){
        return _director + " " + super.getTitle();
    }

    @Override
    public String toString(){
        return super.getString("DVD") + " - " + _director + " - " + _igac;
    }
}