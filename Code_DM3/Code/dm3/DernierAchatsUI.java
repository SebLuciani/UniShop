package dm3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DernierAchatsUI {
    private Scanner scanner;
    private ChoiceMaker choiceMaker;
    private AccountController accountController;
    private InputVerifier inputVerifier;
    private AccountVerifier accountVerifier;

    public DernierAchatsUI(ChoiceMaker choiceMaker, AccountController accountController, InputVerifier inputVerifier, AccountVerifier accountVerifier){
        this.choiceMaker = choiceMaker;
        this.accountController = accountController;
        this.inputVerifier = inputVerifier;
        this.accountVerifier = accountVerifier;
        this.scanner = new Scanner(System.in);
    }

    public void displayDerniersAchatsUI(Acheteur acheteur){
        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Accuser la réception d'une commande");
                System.out.println("2. Consulter l'état d'une commande");
                System.out.println("3. Evaluer une commande");
                System.out.println("4. Signaler un problème");
                System.out.println("5. Demander un retour/echange");
                System.out.println("6. Retourner a l'accueil");
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 6);
                scanner.nextLine();//Pour consume le \n laissé par scanner.nextInt()
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        this.choiceMaker.derniersAchatsDecision(choice1, acheteur);
    }
}
