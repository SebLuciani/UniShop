package dm3;

public class LivresEtManuels extends Produit {
    private int isbn;
    private String auteur;
    private String maisonEdition;
    private String organisation;
    private String genre;
    private String dateParution;
    private int numeroEdition;
    private int numeroVolume;

    public LivresEtManuels(String titre, String categorie, String description, int quantiteInit, double prix, int numPointsBonus, int idUnique, 
                           int isbn, String auteur, String maisonEdition, String organisation, String genre, String dateParution, int numeroEdition, int numeroVolume) {
        super(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
        this.isbn = isbn;
        this.auteur = auteur;
        this.maisonEdition = maisonEdition;
        this.organisation = organisation;
        this.genre = genre;
        this.dateParution = dateParution;
        this.numeroEdition = numeroEdition;
        this.numeroVolume = numeroVolume;
    }

    public int getIsbn(){
        return this.isbn;
    }
    public String getAuteur(){
        return this.auteur;
    }
    public String getMaisonEdition(){
        return this.maisonEdition;
    }
    public String getOrganisation(){
        return this.organisation;
    }
    public String getGenre(){
        return this.genre;
    }
    public String getDateParution(){
        return this.dateParution;
    }
    public int getNumeroEdition(){
        return this.numeroEdition;
    }
    public int getNumeroVolume(){
        return this.numeroVolume;
    }
}