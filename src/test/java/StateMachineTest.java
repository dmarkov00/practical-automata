import org.junit.Test;
import practical.automata.calculations.structures.AutomataFile;
import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.utils.StateMachineFile;

import static org.hamcrest.CoreMatchers.is;


public class StateMachineTest {

    @Test
    public void checkForDFA() {

        StateMachineFile stateMachineFile = new StateMachineFile();

        AutomataFile automataFile = stateMachineFile.readAutomataFile();

        StateMachine stateMachine = automataFile.getStateMachine();

        boolean isDFA = stateMachine.checkForDFA();

    }

    @Test
    public void isWordAccepted() {
        StateMachineFile stateMachineFile = new StateMachineFile();

        AutomataFile automataFile = stateMachineFile.readAutomataFile();

        StateMachine stateMachine = automataFile.getStateMachine();

        String testWord = "aar";

        boolean isAccepted = stateMachine.isWordAccepted(testWord);

    }
}
