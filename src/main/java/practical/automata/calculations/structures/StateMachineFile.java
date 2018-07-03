package practical.automata.calculations.structures;

/**
 * Produced in result of parsing the state machine files
 * Combination between the data parsed from the automaton and the data from the test vectors
 */
public class StateMachineFile {
    private StateMachine stateMachine;
    private TestVector testVector;

    public StateMachineFile(StateMachine stateMachine, TestVector testVector) {
        this.stateMachine = stateMachine;

        this.testVector = testVector;
    }

    public StateMachine getStateMachine() {
        return stateMachine;
    }

    public void setStateMachine(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    public TestVector getTestVector() {
        return testVector;
    }

    public void setTestVector(TestVector testVector) {
        this.testVector = testVector;

    }

}
