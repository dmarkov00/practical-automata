package word_acceptance;

import org.junit.Test;
import practical.automata.calculations.CalculationsManager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class WordAcceptanceTest {
    private CalculationsManager calculationsManager = new CalculationsManager(null);
// TODO: retrieve data from the test vectors
    @Test
    public void areWordsAcceptedTestFile1() {
        String testWordThatShouldBeAccepted = "baab";
        String testWordWithLetterThatDoesNotExistInTheAlphabet = "gaba";
        String testWordThatShouldNotBeAccepted = "baba";

        boolean isAccepted;
        // Set the file we want to test with
        calculationsManager.initializeValuesFromFile("./src/test/resources/word_acceptance/test-file1.txt");

        isAccepted = calculationsManager.isWordAccepted(testWordThatShouldBeAccepted);
        assertTrue(isAccepted);

        isAccepted = calculationsManager.isWordAccepted(testWordWithLetterThatDoesNotExistInTheAlphabet);
        assertFalse(isAccepted);

        isAccepted = calculationsManager.isWordAccepted(testWordThatShouldNotBeAccepted);
        assertFalse(isAccepted);

    }
}
