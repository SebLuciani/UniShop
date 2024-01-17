package dm3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class RechercheUI {
    private Scanner scanner;
    private Acheteur acheteur;
    private ChoiceMaker choiceMaker;
    private AccountController accountController;
    private InputVerifier inputVerifier;

    public RechercheUI(Acheteur acheteur, ChoiceMaker choiceMaker, AccountController accountController, InputVerifier inputVerifier){
        this.acheteur = acheteur;
        this.choiceMaker = choiceMaker;
        this.accountController = accountController;
        this.inputVerifier = inputVerifier;
        this.scanner = new Scanner(System.in);
    }

    public void displayRecherche(){
        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Naviguer à travers les produits");
                System.out.println("2. Rechercher un produit");
                System.out.println("3. Rechercher un vendeur");
                System.out.println("4. Recuperer la liste des acheteurs");
                System.out.println("5. Rechercher un acheteur");
                System.out.println("6. Retourner a l'accueil");
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 6);
                scanner.nextLine();//Pour consume le \n laissé par scanner.nextInt()
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Entree invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        this.choiceMaker.rechercheDecision(choice1, this.acheteur);
    }

    public void rechercheAcheteur(){
        boolean valid = false;

        while (!valid) {
            try {
                System.out.println("Veuillez entrer le pseudo de l'acheteur");
                String pseudo = scanner.nextLine();
                if (this.accountController.acheteurExists(pseudo)){
                    Acheteur acheteur = this.accountController.getAcheteur(pseudo);
                    ArrayList<String> infos = this.accountController.getInfosProfilAch(acheteur);

                    for (String element:infos){
                        System.out.println(element);
                    }
                    valid = true;

                }
                else{
                    System.out.println("Pseudo acheteur invalide");
                    //on garde valid = false et ça va recommencer le loop
                }
            } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            //loop continue pour un autre essai.
        }
        }
    }
}
