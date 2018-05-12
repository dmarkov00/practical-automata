import static org.junit.Assert.*;

import org.junit.Test;
import practical.automata.calculations.structures.AutomataFile;
import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.utils.StateMachineFileReader;

import static org.hamcrest.CoreMatchers.is;


public class StateMachineTest {

    @Test
    public void checkForDFA() {

        StateMachineFileReader stateMachineFileReader = new StateMachineFileReader();

        AutomataFile automataFile = stateMachineFileReader.readAutomataFile();

        StateMachine stateMachine = automataFile.getStateMachine();

        boolean isDFA = stateMachine.checkForDFA();

    }
}
