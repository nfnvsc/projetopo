package m19.core.works;

public enum Category {
    REFERENCE("Referência"),
    FICTION("Ficção"),
    SCITECH("Técnica e Científica"); 

    private String _description;

    Category(String description){
        _description = description;
    }

    public String getDescription(){
        return _description;
    }
}