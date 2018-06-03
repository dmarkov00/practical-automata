package practical.automata.calculations.structures;

/**
 * Used as a backwards referral and store for previous state status in the isWordCalculated Method.(method logic specific)
 */
public class StateStatus {
    private String state;
    private int transitionIndex;
    private StringBuilder word;

    StateStatus(String state, int transitionIndex, StringBuilder word) {
        this.state = state;
        this.transitionIndex = transitionIndex;
        this.word = word;
    }

    public String getState() {
        return state;
    }


    public int getTransitionIndex() {
        return transitionIndex;
    }


    public StringBuilder getWord() {
        return word;
    }

}
