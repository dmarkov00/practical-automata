package practical.automata.calculations.structures;

import practical.automata.calculations.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class StateMachine {
    private String alphabet;
    private List<String> states;
    private List<String> finalStates;
    private List<Transition> transitions;
    private List<String> wordChars;

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

    public boolean checkForDFA() {

        List<String> uniqueTransitions = new ArrayList<>();

        List<String> alphabet = Utils.convertStringToListOfStringCharacters(this.alphabet);

        boolean isDFA = false;

        for (String state : states) {
            for (Transition transition : getTransitions()) {
                if (state.equals(transition.getStateOne())) {

                    // If there is an epsilon transition the state machine is not a DFA
                    if (transition.getTransitionSymbol().equals("_")) {
                        return false;
                    }
                    // The transition symbols can not be repeated in order to have a DFA
                    if (!uniqueTransitions.contains(transition.getTransitionSymbol())) {
                        uniqueTransitions.add(transition.getTransitionSymbol());
                    } else {
                        return false;
                    }

                }
            }
            // If the two collections have equal values, DFA is valid for the current state
            isDFA = alphabet.containsAll(uniqueTransitions);

            uniqueTransitions = new ArrayList<>();
        }

        return isDFA;
    }


    public boolean isWordAccepted(String inputWord) {


        StringBuilder word = new StringBuilder(inputWord);




        return false;

    }


}