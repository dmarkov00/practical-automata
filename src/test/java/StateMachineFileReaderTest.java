import static org.junit.Assert.*;

import org.junit.Test;
import practical.automata.calculations.structures.AutomataFile;
import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.TestVector;
import practical.automata.calculations.structures.Transition;
import practical.automata.calculations.utils.StateMachineFileReader;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;

public class StateMachineFileReaderTest {

    /**
     * TODO: When you setup the file sending via the api endpoint - mock it with files contained in the test resources
     * TODO: Link how to access them https://stackoverflow.com/questions/3891375/how-to-read-a-text-file-resource-into-java-unit-test?utm_medium=organic&utm_source=google_rich_qa&utm_campaign=google_rich_qa
     */

    @Test
    public void readAutomataFile() {

        StateMachineFileReader stateMachineFileReader = new StateMachineFileReader();

        AutomataFile automataFile = stateMachineFileReader.readAutomataFile();

        // Test state machine
        StateMachine stateMachine = automataFile.getStateMachine();

        // Test for correctly retrieved alphabet
        assertThat(stateMachine.getAlphabet(), is("ab"));

        // Test for correctly retrieved states
        List<String> statesListStub = Arrays.asList("Z", "A", "B");
        assertThat(stateMachine.getStates(), is(statesListStub));

        // Test for correctly retrieved final states
        List<String> finalStatesList = Arrays.asList("A", "B");
        assertThat(stateMachine.getFinalStates(), is(finalStatesList));

        // Test for correctly retrieved transitions
        // In this case randomly selected 2nd transition

        Transition transitionStub = new Transition("b", "Z", "B");

        List<Transition> transitions = stateMachine.getTransitions();

        assertThat(transitions.get(1).getTransitionSymbol(), is(transitionStub.getTransitionSymbol()));
        assertThat(transitions.get(1).getStateOne(), is(transitionStub.getStateOne()));
        assertThat(transitions.get(1).getStateTwo(), is(transitionStub.getStateTwo()));

        // Test test vector
        TestVector testVector = automataFile.getTestVector();

        // Test for correctly retrieved DFA
        assertThat(testVector.isDFA(), is("n"));

        // Test for correctly retrieved finite
        assertThat(testVector.isFinite(), is("n"));

        // Test for correctly retrieved finite
        Map<String, String> words = new HashMap<>();
        words.put("bbbbbbbbbb", "y");
        words.put("a", "y");
        words.put("ab", "n");

        assertThat(testVector.getWords(), is(words));


    }

}
