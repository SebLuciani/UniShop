package dm3;
import java.util.concurrent.ThreadLocalRandom;
import java.util.Map;

public class ProduitController {

    private Database database;

    public ProduitController(Database database){
        this.database = database;
    }
    //public Produit getProduitFromCategorie(int n) {

    //};
    //public Produit getProduitFromRecherche(String[] info) {

    //};

    public int generateIDUnique(){
        // Ce code n'est pas efficace lorsque le nombre de produits s'approche à la quantité limite de produits
        boolean valid = false;
        int randomNum = 0;

        // Notre système a une capacité maximale de 10000 produits.
        while(!valid) {
            randomNum = ThreadLocalRandom.current().nextInt(0, 10000 + 1);
            for (Map.Entry<String, Produit> entry : database.getProduits().entrySet()) {
                Produit produit = entry.getValue();
                int idUnique = produit.getIdUnique();
                if (randomNum == idUnique) {
                    break;
                }
            }
            valid = true;
        }
        return randomNum;
    };

    public void modifyProduit(Produit produit) {

    };
    public void modifyPrix(Produit produit, int newPrix){

    };
    public void modifyPointBonus(Produit produit, int newBonus) {

    };
}
