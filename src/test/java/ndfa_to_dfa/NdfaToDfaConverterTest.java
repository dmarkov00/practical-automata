package ndfa_to_dfa;

import org.junit.Test;
import practical.automata.calculations.CalculationsManager;


public class NdfaToDfaConverterTest {
   private CalculationsManager calculationsManager = new CalculationsManager(null);

    @Test
    public void convertToDfaSuccessfully() {
        calculationsManager.convertNdfaToDfa();

        //TODO
    }

}
