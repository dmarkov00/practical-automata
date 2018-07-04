package practical.automata.calculations.structures;

import java.util.List;

public class StateMachine {
    private String alphabet;
    private List<String> states;
    private List<String> finalStates;
    private List<Transition> transitions;

    public StateMachine() {
    }


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
        return finalStates;
    }

    public void setFinalStates(List<String> final_states) {
        this.finalStates = final_states;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }



}