package dm3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainEntranceUI {

    public ChoiceMaker choiceMaker;
    public InputVerifier inputVerifier;

    public MainEntranceUI(ChoiceMaker choiceMaker, InputVerifier inputVerifier){
        this.choiceMaker = choiceMaker;
        this.inputVerifier = inputVerifier;
    }

    public void displayMainEntrance() {
        Scanner scanner = new Scanner(System.in);
        boolean valid = false;
        int choice1 = 0;

        while (!valid) {

            try {
                System.out.println("------------------------------------------------------------");
                System.out.println("Bienvenue sur UniShop!");
                System.out.println("Selectionnez une option parmis les suivantes: ");
                System.out.println("1. Creer un compte");
                System.out.println("2. Se connecter a un compte");
                System.out.println("# NON FONCTIONNEL 3. Quitter application NON FONCTIONNEL #");               // VERIFICAR FUNCIONAMIENTO
                choice1 = scanner.nextInt();
                choice1 = this.inputVerifier.validateInput(choice1, 1, 2);
                valid = true;
            } catch (InputMismatchException e) {
                System.out.println("Entrée invalide, vous devez entrer un entier.");
                scanner.next(); // pour clear l'input invalide et faire un autre essai
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                //loop continue pour un autre essai.
            }
        }

        this.choiceMaker.mainEntranceChoice(choice1);
    }
}