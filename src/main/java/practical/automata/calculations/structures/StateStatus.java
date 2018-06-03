package practical.automata.calculations.structures;

/**
 * Used as a backwards referral and store for previous state status in the isWordCalculated Method.(method logic specific)
 */
public class StateStatus {
    private String state;
    private int transitionIndex;
    private int word;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getTransitionIndex() {
        return transitionIndex;
    }

    public void setTransitionIndex(int transitionIndex) {
        this.transitionIndex = transitionIndex;
    }

    public int getWord() {
        return word;
    }

    public void setWord(int word) {
        this.word = word;
    }
}
