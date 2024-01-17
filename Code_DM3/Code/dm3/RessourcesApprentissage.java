package dm3;

public class RessourcesApprentissage extends Produit {
    private int isbn;
    private String auteur;
    private String organisation;
    private String dateParution;
    private boolean electronique; // true pour electronique false pour imprime
    private int numeroEdition;

    public RessourcesApprentissage(String titre, String categorie, String description, int quantiteInit, double prix, int numPointsBonus, int idUnique, 
                                   int isbn, String auteur, String organisation, String dateParution, boolean electronique, int numeroEdition) {
        super(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
        this.isbn = isbn;
        this.auteur = auteur;
        this.organisation = organisation;
        this.dateParution = dateParution;
        this.electronique = electronique;
        this.numeroEdition = numeroEdition;
    }
}
