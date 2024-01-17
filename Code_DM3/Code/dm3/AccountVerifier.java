package dm3;
import java.util.HashMap;
import java.util.Objects;

public class AccountVerifier {

    private Database database;

    public AccountVerifier(Database database){
        this.database = database;
    }

    public boolean verifyPseudoAcheteur(String pseudo){
        boolean valid = !(database.pseudoExistsAch(pseudo));
        return valid;
    }
    public boolean verifyEmailAcheteur(String email){
        boolean valid = !(database.emailExistsAch(email));
        return valid;
    }
    public boolean verifyNomVendeur(String nom){
        boolean valid = !(database.nomExistsVend(nom));
        return valid;
    }
    public boolean verifyEmailVendeur(String email){
        boolean valid = !(database.emailExistsVend(email));
        return valid;
    }

    public boolean verifyLoginAch(String pseudo, String password){
        HashMap<String, Acheteur> pseudoAcheteur = this.database.getHashAcheteur();
        if (pseudoAcheteur.containsKey(pseudo)){
            Acheteur acheteur = pseudoAcheteur.get(pseudo);
            return Objects.equals(acheteur.getPassword(), password);
        }
        else{return false;}
    }
    public boolean verifyLoginVend(String nom, String password){
        HashMap<String, Vendeur> nomVendeur = this.database.getHashVendeur();
        if (nomVendeur.containsKey(nom)){
            Vendeur vendeur = nomVendeur.get(nom);
            return Objects.equals(vendeur.getPassword(), password);
        }
        else {return false;}
    }
}
