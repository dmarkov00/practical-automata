package utils;

import org.junit.Test;
import practical.automata.calculations.structures.StateMachineFile;
import practical.automata.calculations.utils.StateMachineFileReader;
import practical.automata.calculations.utils.StateMachineImage;

public class StateMachineImageTest {

    /**
     * This one is not a real test but it serves me as a code that generates an image quickly
     */
    @Test
    public void generateImage() {
        StateMachineFileReader stateMachineFileReader = new StateMachineFileReader();

        StateMachineFile stateMachineFile = stateMachineFileReader.readStateMachineFile();

        StateMachineImage.generateImage(stateMachineFile.getStateMachine());
    }
}
