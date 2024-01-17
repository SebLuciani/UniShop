package dm3;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ProfilUI {
    private Scanner scanner;
    private ChoiceMaker choiceMaker;
    private AccountController accountController;
    private InputVerifier inputVerifier;
    private AccountVerifier accountVerifier;

    public ProfilUI(ChoiceMaker choiceMaker, AccountController accountController, InputVerifier inputVerifier, AccountVerifier accountVerifier){
        this.choiceMaker = choiceMaker;
        this.accountController = accountController;
        this.inputVerifier = inputVerifier;
        this.accountVerifier = accountVerifier;
        this.scanner = new Scanner(System.in);
    }

    public void displayProfilAch(Acheteur acheteur){
        ArrayList<String> toDisplay = this.accountController.getInfosProfilAch(acheteur);
        for (String element : toDisplay){
            System.out.println(element);
        }
        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Modifier les informations de mon profil");
                System.out.println("2. Modifier les metriques a afficher dans l'accueil");
                System.out.println("3. Retourner a l'accueil");
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 3);
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
        if (choice1 == 1){
            
            boolean done = false;

            while (!done){
                boolean valid1 = false;
                int choice2 = 0;
                while (!valid1) {

            try {
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Modifier le prenom");
                System.out.println("2. Modifier le nom");
                System.out.println("3. Modifier le pseudo");
                System.out.println("4. Modifier le email");
                System.out.println("5. Modifier l'adresse d'expedition");
                System.out.println("6. Modifier le telephone");
                System.out.println("7. Plus aucune modification");
                choice2 = scanner.nextInt();
                choice2 = this.inputVerifier.validateInput(choice1, 1, 7);
                scanner.nextLine();//Pour consume le \n laissé par scanner.nextInt()
                valid1 = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
            }      
                if (choice2 == 7){
                    done = true;
                    break;
                }
                System.out.println("Veuillez entrer la modification");
                String modif = scanner.nextLine();

                this.choiceMaker.modifProfilAch(choice2, acheteur, modif);
    }
        }
        else if (choice1 == 2){
            //boucle choix métriques
            System.out.println("Sera explicite dans le prochain devoir");
            this.displayProfilAch(acheteur);
        }
        else {
            EcranAccueilUI accueil = new EcranAccueilUI(this.choiceMaker, this.inputVerifier, this.accountVerifier, this.accountController);
            accueil.displayAccueilAch(acheteur);
        }
    }

    public void displayProfilVend(Vendeur vendeur){

        ArrayList<String> toDisplay = this.accountController.getInfosProfilVend(vendeur);
        for (String element : toDisplay){
            System.out.println(element);
        }

        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Modifier les informations de mon profil");
                System.out.println("2. Modifier les metriques a afficher dans l'accueil");
                System.out.println("3. Retourner a l'accueil");
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 3);
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

        if (choice1 == 1){
            
            boolean done = false;

            while (!done){
                boolean valid1 = false;
                int choice2 = 0;
                while (!valid1) {

            try {
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Modifier le nom");
                System.out.println("2. Modifier le email");
                System.out.println("3. Modifier l'adresse d'entrepot");
                System.out.println("4. Modifier le telephone");
                System.out.println("5. Plus aucune modification");
                choice2 = scanner.nextInt();
                choice2 = this.inputVerifier.validateInput(choice1, 1, 5);
                scanner.nextLine();//Pour consume le \n laissé par scanner.nextInt()
                valid1 = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
            }      
                if (choice2 == 5){
                    done = true;
                    break;
                }
                System.out.println("Veuillez entrer la modification");
                String modif = scanner.nextLine();

                this.choiceMaker.modifProfilVend(choice1, vendeur, modif);
    }
        }
        else if (choice1 == 2){
            //boucle choix métriques
            System.out.println("Sera explicite dans le prochain devoir");
            this.displayProfilVend(vendeur);
        }

        else {
            EcranAccueilUI accueil = new EcranAccueilUI(this.choiceMaker, this.inputVerifier, this.accountVerifier, this.accountController);
            accueil.displayAccueilVend(vendeur);
        }
    }



}
