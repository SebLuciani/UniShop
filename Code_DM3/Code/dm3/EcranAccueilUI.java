package dm3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class EcranAccueilUI {
    private Scanner scanner;
    public ChoiceMaker choiceMaker;
    public InputVerifier inputVerifier;
    public AccountVerifier accountVerifier;
    public AccountController accountController;

    public EcranAccueilUI(ChoiceMaker choiceMaker, InputVerifier inputVerifier, AccountVerifier accountVerifier, AccountController accountController) {
        this.scanner = new Scanner(System.in);
        this.choiceMaker = choiceMaker;
        this.inputVerifier = inputVerifier;
        this.accountVerifier = accountVerifier;
        this.accountController = accountController;
    }
    public void displayAccueilAch(Acheteur acheteur){

        //Display les informations
        System.out.println("-----------Accueil----------");
        ArrayList<String> infos = this.accountController.getInfosAccueilAch(acheteur);
        for (String element : infos) {
        System.out.println(element);
            }

        //Display les choix
        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("------------------------------------------------------------");
                System.out.println("Veuillez selectionner un choix parmis les suivants: ");
                System.out.println("1. Consulter mon profil et mes metriques ");
                System.out.println("2. Consulter mes derniers achats");
                System.out.println("3. Effectuer une recherche de produits ou de vendeurs");
                System.out.println("4. Consulter mon timeline");
                System.out.println("5. Se deconnecter");
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 5);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        this.choiceMaker.ecranAccueilAchDecision(choice1, acheteur);

    }
    public void displayAccueilVend(Vendeur vendeur){

        //Display les informations
        System.out.println("-----------Accueil----------");
        ArrayList<String> infos = this.accountController.getInfosAccueilVend(vendeur);
        for (String element : infos) {
        System.out.println(element);
            }
        //Display les choix
        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("------------------------------------------------------------");
                System.out.println("Veuillez selectionner un choix parmis les suivants: ");
                System.out.println("1. Consulter mon profil et mes metriques ");
                System.out.println("2. Consulter mes ventes");
                System.out.println("3. Mettre un produit en vente");
                System.out.println("4. Se deconnecter");
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 4);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        this.choiceMaker.ecranAccueilVendDecision(choice1, vendeur);
    }
}
