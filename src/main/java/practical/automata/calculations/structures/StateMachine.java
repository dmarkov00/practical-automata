package practical.automata.calculations.structures;

import java.util.List;
import java.util.Map;

public class StateMachine {
    private String alphabet;
    private List<String> states;
    private List<String> final_states;
    private List<Transition> transitions;

    public String getAlphabet() {
        return alphabet;
    }

    public void setAlphabet(String alphabet) {
        this.alphabet = alphabet;
    }

    public List<String> getStates() {
        return states;
    }

    public void setStates(List<String> states) {
        this.states = states;
    }

    public List<String> getFinalStates() {
        return final_states;
    }

    public void setFinalStates(List<String> final_states) {
        this.final_states = final_states;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }
}
