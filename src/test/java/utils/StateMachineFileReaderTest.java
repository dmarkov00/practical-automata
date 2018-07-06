package utils;

import static org.junit.Assert.*;

import org.junit.Test;
import practical.automata.calculations.structures.StateMachineFile;
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

    @Test
    public void readAutomataFile() {

        StateMachineFileReader stateMachineFileReader = new StateMachineFileReader();

        StateMachineFile stateMachineFile = stateMachineFileReader.readStateMachineFile();

        // Test state machine
        StateMachine stateMachine = stateMachineFile.getStateMachine();

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
        TestVector testVector = stateMachineFile.getTestVector();

        // Test for correctly retrieved DFA
        assertThat(testVector.isDFA(), is("n"));

        // Test for correctly retrieved indicate_finite
        assertThat(testVector.isFinite(), is("n"));

        // Test for correctly retrieved indicate_finite
        Map<String, String> words = new HashMap<>();
        words.put("bbbbbbbbbb", "y");
        words.put("a", "y");
        words.put("ab", "n");

        assertThat(testVector.getWords(), is(words));


    }

}
