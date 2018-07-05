package practical.automata.calculations.word_acceptance;

/**
 * Used as a backwards referral and store for previous state status in the isWordAccepted.(method logic specific)
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


    int getTransitionIndex() {
        return transitionIndex;
    }


    StringBuilder getWord() {
        return word;
    }

}
