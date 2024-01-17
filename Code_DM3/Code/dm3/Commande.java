package dm3;

import java.util.ArrayList;

public class Commande {
    private ArrayList<Produit> produits;
    private int etat; //0 pour en production, 1 pour en livraison et 2 pour livre

    public Commande(ArrayList<Produit> produits){
        this.produits = produits;
        this.etat = 0;
    }

    public void enLivraison(){
        this.etat = 1;
    }
    public void livre(){
        this.etat = 2;  
    }
}
