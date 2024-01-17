package dm3;

import java.util.ArrayList;
import java.util.HashMap;

public class AccountController {
    private Database database;

    public AccountController(Database database) {
        this.database = database;
    }

    public void createAccountAch(String prenom, String nom, String pseudo, String email, String adresseExpedition, String telephone, String password) {
        Acheteur newAcheteur = new Acheteur(prenom, nom, pseudo, email, adresseExpedition, telephone, password);
        this.database.addAcheteur(newAcheteur);
    }

    public void createAccountVend(String nom, String courriel, String telephone, String adresse, String password) {
        Vendeur newVendeur = new Vendeur(nom, courriel, telephone, adresse, password);
        this.database.addVendeur(newVendeur);
    }

    public Acheteur getAcheteur(String pseudo) {
        if (this.database.getHashAcheteur().containsKey(pseudo)){
            return this.database.getHashAcheteur().get(pseudo);
        }
        return this.database.getHashAcheteur().get(pseudo);
    }

    public boolean acheteurExists(String pseudo){
        return this.database.getHashAcheteur().containsKey(pseudo);
    }

    public Vendeur getVendeur(String nom) {
        return this.database.getHashVendeur().get(nom);
    }

    public ArrayList<String> getInfosAccueilAch(Acheteur acheteur) {

        ArrayList<String> infos = new ArrayList<>();
        infos.add("Notifications:");
        ArrayList<String> notifs = acheteur.getNotifs();
        for (String element : notifs) {
            infos.add(element);
        }
        infos.add("Metriques:");
        ArrayList<String> metriques = acheteur.getMetriques();
        for (String element : metriques) {
            infos.add(element);
        }

        return infos;
    }

    public ArrayList<String> getInfosProfilAch(Acheteur acheteur) {

        ArrayList<String> infos = new ArrayList<>();
        infos.add("Informations:");
        infos.add("Prenom: " + acheteur.getPrenom());
        infos.add("Nom: " + acheteur.getNom());
        infos.add("Pseudo: " + acheteur.getPseudo());
        infos.add("Email: " + acheteur.getEmail());
        infos.add("Adresse d'expedition: " + acheteur.getAdresseExpedition());
        infos.add("Telephone: " + acheteur.getTelephone());

        infos.add("Metriques:");
        ArrayList<String> metriques = acheteur.getMetriques();
        for (String element : metriques) {
            infos.add(element);
        }

        return infos;
    }

    public ArrayList<String> getInfosAccueilVend(Vendeur vendeur) {
        ArrayList<String> infos = new ArrayList<>();
        infos.add("Notifications:");
        ArrayList<String> notifs = vendeur.getNotifs();
        for (String element : notifs) {
            infos.add(element);
        }
        infos.add("Metriques:");
        ArrayList<String> metriques = vendeur.getMetriques();
        for (String element : metriques) {
            infos.add(element);
        }

        return infos;
    }

    public ArrayList<String> getInfosProfilVend(Vendeur vendeur) {

        ArrayList<String> infos = new ArrayList<>();
        infos.add("Informations:");
        infos.add("Nom: " + vendeur.getNom());
        infos.add("Email: " + vendeur.getEmail());
        infos.add("Adresse d'entrepot: " + vendeur.getAdresseEntrepot());
        infos.add("Telephone: " + vendeur.getTelephone());

        infos.add("Metriques:");
        ArrayList<String> metriques = vendeur.getMetriques();
        for (String element : metriques) {
            infos.add(element);
        }

        return infos;
    }

    public void showAllAcheteurs() {
        HashMap<String, Acheteur> hashAcheteurs = this.database.getHashAcheteur();

        for (String key : hashAcheteurs.keySet()) {
            System.out.println(key);
        }
    }
}
