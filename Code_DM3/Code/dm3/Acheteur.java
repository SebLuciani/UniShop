package dm3;

import java.util.ArrayList;

public class Acheteur {
    private String prenom;
    private String nom;
    private String pseudo;
    private String email;
    private String adresseExpedition;
    private String telephone;
    private String password;
    private ArrayList<String> notifications;
    private ArrayList<String> metriques;
    private ArrayList<Acheteur> suiveurs;
    private ArrayList<Commande> commandes;
    


    public Acheteur(String prenom, String nom, String pseudo, String email, String adresseExpedition, String telephone, String password){
        this.prenom = prenom;
        this.nom = nom;
        this.pseudo = pseudo;
        this.email = email;
        this.adresseExpedition = adresseExpedition;
        this.telephone = telephone;
        this.password = password;
        this.notifications = new ArrayList<>();
        this.metriques = new ArrayList<>();
        this.suiveurs = new ArrayList<>();
        this.commandes = new ArrayList<>();
    }
    public String getPrenom(){
        return this.prenom;
    }
    public void setPrenom(String newPrenom){
        this.prenom = newPrenom;
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String newNom){
        this.nom = newNom;
    }
    public String getPseudo(){
        return this.pseudo;
    }
    public void setPseudo(String newPseudo){
        this.pseudo = newPseudo;
    }
    public String getPassword(){
        return this.password;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String newEmail){
        this.email = newEmail;
    }
    public String getAdresseExpedition(){
        return this.adresseExpedition;
    }
    public void setAdresse(String newAdresse){
        this.adresseExpedition = newAdresse;
    }
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String newTelephone){
        this.telephone = newTelephone;
    }
    public ArrayList<String> getNotifs(){
        return this.notifications;
    }
    public ArrayList<String> getMetriques(){
        return this.metriques;
    }
    public void addFollower(Acheteur acheteurFollower){
        this.suiveurs.add(acheteurFollower);
    }
    public void addCommande(Commande commande){
        this.commandes.add(commande);
    }


}
