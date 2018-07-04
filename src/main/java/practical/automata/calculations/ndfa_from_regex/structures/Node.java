package practical.automata.calculations.ndfa_from_regex.structures;

import practical.automata.calculations.structures.Transition;

import java.util.List;

public class Node {

    private char value;
    private List<Transition> transitions;

    Node(char value) {

        this.value = value;

    }

    public char getValue() {

        return value;
    }

    public List<Transition> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<Transition> transitions) {
        this.transitions = transitions;
    }
}
