import org.junit.Test;
import practical.automata.calculations.structures.StateMachineFile;
import practical.automata.calculations.utils.StateMachineFileReader;
import practical.automata.calculations.utils.StateMachineImage;

public class StateMachineImageTest {

    @Test
    public void generateImage() {
        StateMachineFileReader stateMachineFileReader = new StateMachineFileReader();

        StateMachineFile stateMachineFile = stateMachineFileReader.readStateMachineFile();

        StateMachineImage.generateImage(stateMachineFile.getStateMachine());
    }
}
