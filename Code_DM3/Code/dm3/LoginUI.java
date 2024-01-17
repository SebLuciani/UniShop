package dm3;
import java.util.InputMismatchException;
import java.util.Scanner;

public class LoginUI {
    private Scanner scanner;
    public ChoiceMaker choiceMaker;
    public InputVerifier inputVerifier;
    public AccountVerifier accountVerifier;
    public AccountController accountController;

    public LoginUI(ChoiceMaker choiceMaker, InputVerifier inputVerifier, AccountVerifier accountVerifier, AccountController accountController) {
        this.scanner = new Scanner(System.in);
        this.choiceMaker = choiceMaker;
        this.inputVerifier = inputVerifier;
        this.accountVerifier = accountVerifier;
        this.accountController = accountController;
    }

    public void displayLoginScreen() {
        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("A quel type de compte souhaitez-vous vous connecter?");
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Compte Acheteur");
                System.out.println("2. Compte Vendeur");
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 2);
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
        boolean acheteur = this.choiceMaker.loginAccountAchOuVend(choice1);

        if (acheteur) {
            boolean isAuthenticated = false;

            while (!isAuthenticated) {
                System.out.println("Veuillez entrer votre pseudo");
                String pseudo = scanner.nextLine();

                System.out.println("Veuillez entrer votre mot de passe");
                String password = scanner.nextLine();

                if (this.accountVerifier.verifyLoginAch(pseudo, password)) {
                    Acheteur user = this.accountController.getAcheteur(pseudo);
                    EcranAccueilUI accueil = new EcranAccueilUI(choiceMaker, inputVerifier, accountVerifier, accountController);
                    accueil.displayAccueilAch(user);
                    isAuthenticated = true;
                } else {
                    System.out.println("Informations invalides, veuillez reessayer");
                }
            }
        }
        else {
            boolean isAuthenticated = false;
            while (!isAuthenticated) {
                System.out.println("Veuillez entrer votre nom");
                String nom = scanner.nextLine();

                System.out.println("Veuillez entrer votre mot de passe");
                String password = scanner.nextLine();

                if (this.accountVerifier.verifyLoginVend(nom, password)){
                    Vendeur user = this.accountController.getVendeur(nom);
                    EcranAccueilUI accueil = new EcranAccueilUI(choiceMaker, inputVerifier, accountVerifier, accountController);
                    accueil.displayAccueilVend(user);
                    isAuthenticated = true;
                }
                else{
                    System.out.println("Informations invalides, veuillez reessayer");
                }
            }
        }
    }
}