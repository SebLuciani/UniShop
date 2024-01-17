package dm3;

import java.util.Scanner;

public class TimelineUI {
    private Scanner scanner;
    private Acheteur acheteur;
    private ChoiceMaker choiceMaker;
    private AccountController accountController;
    private InputVerifier inputVerifier;
    private AccountVerifier accountVerifier;

    public TimelineUI(Acheteur acheteur, ChoiceMaker choiceMaker, AccountController accountController, InputVerifier inputVerifier, AccountVerifier accountVerifier){
        this.acheteur = acheteur;
        this.choiceMaker = choiceMaker;
        this.accountController = accountController;
        this.inputVerifier = inputVerifier;
        this.scanner = new Scanner(System.in);
        this.accountVerifier = accountVerifier;
    }

    public void displayTimeline(){
        //Account controller va chercher les followed acheteurs de l'objet acheteur.
        //puis va les afficher sur cette interface
        System.out.println("fonctionnalite non disponible, retour au profil");
        ProfilUI profil = new ProfilUI(this.choiceMaker, this.accountController, this.inputVerifier, this.accountVerifier);
        profil.displayProfilAch(acheteur);
    }
}
