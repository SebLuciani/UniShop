package dm3;

public class MaterielInformatique extends Produit {
    private String marque;
    private String modele;
    private String dateLancement;
    private String sousCat; //comme une description

    public MaterielInformatique(String titre, String categorie, String description, int quantiteInit, double prix, int numPointsBonus, int idUnique,
                                String marque, String modele, String dateLancement, String sousCat) {
        super(titre, categorie, description, quantiteInit, prix, numPointsBonus, idUnique);
        this.marque = marque;
        this.modele = modele;
        this.dateLancement = dateLancement;
        this.sousCat = sousCat;
    }
}
