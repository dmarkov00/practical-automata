package indicate_dfa;

import org.junit.Test;
import practical.automata.calculations.CalculationsManager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * This test files are manually checked and they are legitimate
 */
public class DfaIndicatorTest {

    // Pass null for file path for now
    private CalculationsManager calculationsManager = new CalculationsManager(null);


    @Test
    public void checkForDfaWithDfaTestFile() {
        // Set the file we want to test with
        calculationsManager.initializeValuesFromFile("./src/test/resources/indicate_dfa/dfa-state-machine.txt");

        boolean isDFA = calculationsManager.indicateDFA();

        assertTrue(isDFA);
    }

    /**
     * If a file has an empty transition it should be false
     */
    @Test
    public void checkForDfaWithNdfaWithEmptyTransitionsTestFile() {
        // Set the file we want to test with
        calculationsManager.initializeValuesFromFile("./src/test/resources/indicate_dfa/ndfa-state-machine-with-empty-transition.txt");

        boolean isDFA = calculationsManager.indicateDFA();

        assertFalse(isDFA);
    }
    /**
     * The file is not using all transitions symbols from all states
     */
    @Test
    public void checkForDfaWithNdfaTestFile() {
        // Set the file we want to test with
        calculationsManager.initializeValuesFromFile("./src/test/resources/indicate_dfa/ndfa-state-machine.txt");

        boolean isDFA = calculationsManager.indicateDFA();

        assertFalse(isDFA);
    }

}
