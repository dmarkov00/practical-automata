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

    public boolean isWordAccepted(String inputWordChars) {

        this.wordChars = Utils.convertStringToListOfStringCharacters(inputWordChars);


        List<Transition> startingTransactions = this.startingTransitions();

//        int focusSymbolIndex = 0;
        for (Transition startingTransaction : startingTransactions) {

            boolean isAccepted = evaluateWord(startingTransaction, 0);

            if (isAccepted) {
                return true;
            }
        }
        return false;
    }

    private List<Transition> startingTransitions() {
        List<Transition> startingTransitions = new ArrayList<>();
        for (Transition transition : getTransitions()) {
            if (transition.getStateOne().equals(getStates().get(0))) {
                startingTransitions.add(transition);
            }
        }
        return startingTransitions;
    }


    private boolean evaluateWord(Transition focusTransition, int focusSymbolIndex) {

        if (focusSymbolIndex == wordChars.size() - 1 && getFinalStates().contains(focusTransition.getStateTwo())) {
            return true;
        }

        for (Transition transition : getTransitions()) {
            if (focusSymbolIndex < wordChars.size() && focusTransition.getStateTwo().equals(transition.getStateOne())
                    && transition.getTransitionSymbol().equals(wordChars.get(focusSymbolIndex))) {

                focusTransition = transition;
                focusSymbolIndex++;
                return evaluateWord(focusTransition, focusSymbolIndex);
            }
        }
        return false;

    }

}