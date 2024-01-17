package dm3;

public class VendeurControler {

    private Database database;

    public VendeurControler(Database database){
        this.database = database;
    }

    public void vendreProduit(Produit produit){
        database.addProduit(produit);
    }


}
