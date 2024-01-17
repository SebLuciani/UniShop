package dm3;

import java.util.ArrayList;

public class Vendeur {
    private String nom;
    private String email;
    private String telephone;
    private String adresseEntrepot;
    private String password;
    private ArrayList<String> notifications;
    private ArrayList<String> metriques;

    public Vendeur(String nom, String courriel, String telephone, String adresseEntrepot, String password){
        this.nom = nom;
        this.email = courriel;
        this.telephone = telephone;
        this.adresseEntrepot = adresseEntrepot;
        this.password = password;
        this.notifications = new ArrayList<>();
        this.metriques = new ArrayList<>();
        
    }
    public String getNom(){
        return this.nom;
    }
    public void setNom(String newModif){
        this.nom = newModif;
    }
    public String getEmail(){
        return this.email;
    }
    public void setEmail(String newModif){
        this.email = newModif;
    }
    public String getTelephone(){
        return this.telephone;
    }
    public void setTelephone(String newModif){
        this.telephone = newModif;
    }
    public String getAdresseEntrepot(){
        return this.adresseEntrepot;
    }
    public void setAdresseEntrepot(String newModif){
        this.adresseEntrepot = newModif;
    }
    public String getPassword(){
        return this.password;
    }
    public ArrayList<String> getNotifs(){
        return this.notifications;
    }
    public ArrayList<String> getMetriques(){
        return this.metriques;
    }
}
