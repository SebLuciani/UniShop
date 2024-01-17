package dm3;
import java.util.InputMismatchException;
import java.util.Scanner;

public class CreateAnAccountUI {
    private Scanner scanner;
    public ChoiceMaker choiceMaker;
    public InputVerifier inputVerifier;
    public AccountVerifier accountVerifier;
    public AccountController accountController;

    public CreateAnAccountUI(ChoiceMaker choiceMaker, InputVerifier inputVerifier, AccountVerifier accountVerifier, AccountController accountController) {
        this.scanner = new Scanner(System.in);
        this.choiceMaker = choiceMaker;
        this.inputVerifier = inputVerifier;
        this.accountVerifier = accountVerifier;
        this.accountController = accountController;
    }
    private void displayAcheteurInfo(String prenom, String nom, String pseudo, String courriel, String telephone, String adresse) {
        
        System.out.println("------------------------------------------------------------");
        System.out.println("Le compte cree aura ces informations, vous allez pouvoir les modifier plus tard au besoin:");
        System.out.println("Prenom et nom: " + prenom + " " + nom);
        System.out.println("Pseudo: " + pseudo);
        System.out.println("Courriel: " + courriel);
        System.out.println("Numero de telephone: " + telephone);
        System.out.println("Adresse d'expédition: " + adresse);
        System.out.println("------------------------------------------------------------");
    }

    private void displayVendeurInfo(String nom, String courriel, String telephone, String adresse) {

        System.out.println("------------------------------------------------------------");
        System.out.println("Le compte cree aura ces informations, vous allez pouvoir les modifier plus tard au besoin:");
        System.out.println("Nom: " + nom);
        System.out.println("Courriel: " + courriel);
        System.out.println("Numero de telephone: " + telephone);
        System.out.println("Adresse d'entrepot: " + adresse);
        System.out.println("------------------------------------------------------------");
    }
    
    public void displayCreateAccountScreen() {

        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("Quel type de compte souhaitez-vous creer?");
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Compte Acheteur");
                System.out.println("2. Compte Vendeur");
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 2);
                scanner.nextLine();
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }
        boolean acheteur = this.choiceMaker.createAccountAchOuVend(choice1);

        if (acheteur) {

            System.out.println("Entrez votre prenom: ");
            String prenom = scanner.nextLine();

            System.out.println("Entrez votre nom: ");
            String nom = scanner.nextLine();

            System.out.println("Entrez votre numero de telephone: ");
            System.out.println("Format XXX-XXX-XXXX");
            //On dit qu'on suppose qu'on fait affaire juste au Canada
            String telephone = scanner.nextLine();
            System.out.println("Entrez votre adresse d'expedition: ");
            //On dit qu'on suppose qu'on fait affaire juste au Canada
            String adresse = scanner.nextLine();
            String pseudo = "";
            String courriel = "";
            
            while (true){
                System.out.println("Entrez votre pseudo: ");
                pseudo = scanner.nextLine();
                if (this.accountVerifier.verifyPseudoAcheteur(pseudo)){
                    System.out.println("Pseudo choisi est valide");
                    break;
                }
                else {
                    System.out.println("Pseudo existe deja. Veuillez en choisir un autre.");
                }
            }
            while (true){
                System.out.println("Entrez votre adresse courriel: ");
                //Vérifier si adresse valide for sure right?
                courriel = scanner.nextLine();
                if (this.accountVerifier.verifyEmailAcheteur(courriel)){
                    System.out.println("Email choisi est valide");
                    break;
                }
                else {
                    System.out.println("Courriel existe deja veuillez en choisir un autre.");
                }
            }

            System.out.println("Veuillez entrer votre mot de passe choisi");
            String password = scanner.nextLine();
            displayAcheteurInfo(prenom, nom, pseudo, courriel, telephone, adresse);
                //Je pense qu'on est mieux de juste terminer ici. On suppose qu'il pourra modifier à partir de son compte

                //Creer un compte:
            this.accountController.createAccountAch(prenom, nom, pseudo, courriel, adresse, telephone, password);
            System.out.println("Compte acheteur cree avec succes. Veuillez vous connecter dans les 24h suivantes pour valider votre compte");

        }

        else {
            String nom = "";
            while (true){
                System.out.println("Entrez votre nom: ");
                nom = scanner.nextLine();
                if (this.accountVerifier.verifyNomVendeur(nom)){
                    System.out.println("Nom choisi est valide");
                    break;
                }
                else {
                    System.out.println("Ce nom existe deja dans notre systeme, veuillez en choisir un autre.");
                }
            }

            String courriel = "";
            while (true){
                System.out.println("Entrez votre adresse courriel: ");
                courriel = scanner.nextLine();
                if (this.accountVerifier.verifyEmailVendeur(courriel)){
                    System.out.println("Email choisi est valide");
                    break;
                }
                else {
                    System.out.println("Courriel existe deja veuillez en choisir un autre.");
                }
            }
            System.out.println("Entrez votre adresse d'entrepot: ");
            //On dit qu'on suppose qu'on fait affaire juste au Canada
            String adresse = scanner.nextLine();

            System.out.println("Entrez votre numero de telephone: ");
            System.out.println("Format XXX-XXX-XXXX");
            //On dit qu'on suppose qu'on fait affaire juste au Canada
            String telephone = scanner.nextLine();

            System.out.println("Veuillez entrer votre mot de passe choisi");
            String password = scanner.nextLine();

            displayVendeurInfo(nom, courriel, telephone, adresse);

            this.accountController.createAccountVend(nom, courriel, telephone, adresse, password);
            System.out.println("Compte vendeur cree avec succes. Veuillez vous connecter dans les 24h suivantes pour valider votre compte");



        }           
            
    }
        
}


