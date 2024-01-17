package dm3;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InputVerifierTest {

    @Test
    void validateInputWithinRange() {
        int testNumber = 5;
        InputVerifier inputVerifier = new InputVerifier();
        int min = 1;
        int max = 6;

        assertEquals(5, inputVerifier.validateInput(testNumber, min, max));
    }

    @Test
    void validateInputBelowRange() {
        int testNumber = 1;
        InputVerifier inputVerifier = new InputVerifier();
        int min = 5;
        int max = 10;

        assertThrows(IllegalArgumentException.class, () -> {
            inputVerifier.validateInput(testNumber, min, max);
        });
    }

    @Test
    void validateInputAboveRange() {
        int testNumber = 10;
        InputVerifier inputVerifier = new InputVerifier();
        int min = 4;
        int max = 7;

        assertThrows(IllegalArgumentException.class, () -> {
            inputVerifier.validateInput(testNumber, min, max);
        });
    }
}


