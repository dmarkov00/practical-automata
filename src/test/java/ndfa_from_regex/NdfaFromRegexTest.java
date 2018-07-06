package ndfa_from_regex;

import org.junit.Test;
import practical.automata.calculations.CalculationsManager;
import practical.automata.calculations.structures.StateMachine;

import static org.hamcrest.CoreMatchers.is;

import static org.junit.Assert.assertThat;


public class NdfaFromRegexTest {
    private CalculationsManager calculationsManager = new CalculationsManager(null);

    @Test
    public void returnsCorrectLinesFromRegex() {
        // We generate
        calculationsManager.generateNdfaFromRegex(".(a,b)");

        // Re-read the new file that was generated on the file system
        calculationsManager.initializeValuesFromFile(null); // When we initialize values from file

        // Retrieve the newly generated state machine
        StateMachine stateMachine = calculationsManager.stateMachineFile.getStateMachine();

        // Do some asserts
        assertThat(stateMachine.getAlphabet(), is("ab"));
        assertThat(stateMachine.getFinalStates().get(0), is("A"));
        assertThat(stateMachine.getTransitions().get(0).getStateOne(), is("A"));
        assertThat(stateMachine.getTransitions().get(0).getStateTwo(), is("B"));
        assertThat(stateMachine.getTransitions().get(0).getTransitionSymbol(), is("a"));

    }
}
