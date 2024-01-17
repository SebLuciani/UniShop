package dm3;

import java.util.Scanner;

public class VentesUI {
    private Scanner scanner;
    private ChoiceMaker choiceMaker;
    private AccountController accountController;
    private InputVerifier inputVerifier;
    private AccountVerifier accountVerifier;

    public VentesUI(ChoiceMaker choiceMaker, AccountController accountController, InputVerifier inputVerifier, AccountVerifier accountVerifier){
        this.choiceMaker = choiceMaker;
        this.accountController = accountController;
        this.inputVerifier = inputVerifier;
        this.accountVerifier = accountVerifier;
        this.scanner = new Scanner(System.in);
    }

    public void displayVentes(Vendeur vendeur){
        //C'est ici qu'on pourra changer l'etat d'une commande et gerer des problemes
        System.out.println("fonctionnalite non disponible, retour a l'accueil");
        EcranAccueilUI accueil = new EcranAccueilUI(choiceMaker, inputVerifier, accountVerifier, accountController);
        accueil.displayAccueilVend(vendeur);
    }
}
