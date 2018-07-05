package ndfa_to_dfa;

import org.junit.Test;
import practical.automata.calculations.CalculationsManager;


public class NdfaToDfaConverterTest {
    CalculationsManager calculationsManager = new CalculationsManager(null);

    @Test
    public void testing() {
        calculationsManager.convertNdfaToDfa();

    }

}
