package practical.automata.calculations.finite;

import java.util.ArrayList;
import java.util.List;

/**
 * This State object is logic specific for generating words
 */
public class State {
    private List<State> inputStates;
    private List<State> outputStates;
    private String word;
    public String transitionSymbol;
    public String state;

    public State(List<State> inputStates, List<State> outputStates) {
        this.inputStates = inputStates;
        this.outputStates = outputStates;
    }

    public List<State> getInputStates() {
        return inputStates;
    }

    public List<State> getOutputStates() {
        return outputStates;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }
}


