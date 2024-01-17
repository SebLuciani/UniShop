package dm3;

public class InputVerifier {
    public int validateInput(int input, int startRange, int endRange) throws IllegalArgumentException {
        if (input < startRange || input > endRange) {
            throw new IllegalArgumentException("Choix invalide. Veuillez entrer un entier de " + startRange + " a " + endRange + ".");
        }
        return input;
    }
}
