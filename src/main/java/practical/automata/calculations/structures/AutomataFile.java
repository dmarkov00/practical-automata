package practical.automata.calculations.structures;

public class AutomataFile {
    private StateMachine stateMachine;
    private TestVector testVector;

    public AutomataFile(StateMachine stateMachine, TestVector testVector) {
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
