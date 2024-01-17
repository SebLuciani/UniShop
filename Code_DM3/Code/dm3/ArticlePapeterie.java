package dm3;

public class ArticlePapeterie extends Produit {
    private String marque;
    private String modele;
    private String sousCat; //comme une description

    public ArticlePapeterie(String titre, String categorie, String description, int quantiteInit, double prix, int numPointsBonus, int idUnique,
                     String marque, String modele, String sousCat) {
        super(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
        this.marque = marque;
        this.modele = modele;
        this.sousCat = sousCat;
    }

    public String getMarque(){
        return this.marque;
    }
    public String getModele(){
        return this.modele;
    }
    public String getSousCat(){
        return this.sousCat;
    }
}
