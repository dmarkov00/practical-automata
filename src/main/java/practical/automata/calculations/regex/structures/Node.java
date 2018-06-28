package practical.automata.calculations.regex.structures;

import java.util.List;

public class Node {

    private char value;
    private List<String> transitions;

    Node(char value) {

        this.value = value;

    }

    public char getValue() {

        return value;
    }

    public List<String> getTransitions() {
        return transitions;
    }

    public void setTransitions(List<String> transitions) {
        this.transitions = transitions;
    }
}
