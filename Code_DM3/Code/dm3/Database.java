package dm3;

import java.util.HashMap;

public class Database {
    private HashMap<String, Acheteur> pseudoAcheteur;
    private HashMap<String, Acheteur> emailAcheteur;

    private HashMap<String, Vendeur> nomVendeur;
    private HashMap<String, Vendeur> emailVendeur;

    private HashMap<String, Produit> produits; // Définit comme le nom du produit et puis le produit.

    public Database() {
        this.pseudoAcheteur = new HashMap<>();
        this.emailAcheteur = new HashMap<>();

        this.nomVendeur = new HashMap<>();
        this.emailVendeur = new HashMap<>();

        this.produits = new HashMap<>();
    }

    public void addAcheteur(Acheteur acheteur) {
        pseudoAcheteur.put(acheteur.getPseudo(), acheteur);
        emailAcheteur.put(acheteur.getEmail(), acheteur);
    }

    public void addVendeur(Vendeur vendeur) {
        nomVendeur.put(vendeur.getNom(), vendeur);
        emailVendeur.put(vendeur.getEmail(), vendeur);
    }

    public void addProduit(Produit produit){
        produits.put(produit.getTitre(), produit);
    }

    public boolean pseudoExistsAch(String pseudo){
        boolean exists = this.pseudoAcheteur.containsKey(pseudo);
        return exists;
    }
    public boolean emailExistsAch(String email){
        boolean exists = this.emailAcheteur.containsKey(email);
        return exists;
    }

    public boolean nomExistsVend(String nom){
        boolean exists = this.nomVendeur.containsKey(nom);
        return exists;
    }
    public boolean emailExistsVend(String email){
        boolean exists = this.emailVendeur.containsKey(email);
        return exists;
    }

    public boolean produitExists(String nom){
        boolean exists = this.produits.containsKey(nom);
        return exists;
    }

    public HashMap<String,Acheteur> getHashAcheteur(){
        return this.pseudoAcheteur;
    }
    public HashMap<String,Vendeur> getHashVendeur(){
        return this.nomVendeur;
    }
    public HashMap<String, Produit> getProduits() {return this.produits; }

}
