import org.junit.Test;
import practical.automata.calculations.structures.AutomataFile;
import practical.automata.calculations.utils.StateMachineFile;
import practical.automata.calculations.utils.StateMachineImage;

public class StateMachineImageTest {

    @Test
    public void generateImage() {
        StateMachineFile stateMachineFile = new StateMachineFile();

        AutomataFile automataFile = stateMachineFile.readAutomataFile();

        StateMachineImage.generateImage(automataFile.getStateMachine());
    }
}
