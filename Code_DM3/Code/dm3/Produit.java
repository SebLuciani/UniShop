package dm3;

public class Produit {
    private String titre;
    private String categorie;
    private String description;
    private int quantiteInit;
    private double prix;
    private int numPointsBonus;
    private int idUnique;

    public Produit(String titre, String categorie, String description, int quantiteInit, double prix, int numPointsBonus, int idUnique) {
        this.titre = titre;
        this.categorie = categorie;
        this.description = description;
        this.quantiteInit = quantiteInit;
        this.prix = prix;
        this.numPointsBonus = numPointsBonus;
        this.idUnique = idUnique;
    }

    public String getTitre() {
        return this.titre;
    }
    public String getCategorie() {
        return this.categorie;
    }
    public String getDescription(){
        return this.description;
    }
    public int getQuantiteInit() {
        return this.quantiteInit;
    }
    public double getPrix(){
        return this.prix;
    }
    public int getNumPointsBonus(){
        return this.numPointsBonus;
    }
    public int getIdUnique(){
        return this.idUnique;
    }
}
