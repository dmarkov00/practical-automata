package indicate_dfa;

import org.junit.Test;
import practical.automata.calculations.CalculationsManager;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 *
 */
public class DfaIndicatorTest {

    // Pass null for file path for now
    CalculationsManager calculationsManager = new CalculationsManager(null);

    /**
     * This test file is manually checked and it is not a DFA
     */
    @Test
    public void checkForDfaWithTestFile1() {
        // Set the file we want to test with
        calculationsManager.InitializeValuesFromFile("./src/test/resources/test.txt");

        boolean isDFA = calculationsManager.indicateDFA();

        assertFalse(isDFA);
    }

}
