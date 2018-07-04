package practical.automata.calculations.structures;

import practical.automata.calculations.utils.Utils;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class StateMachine {
    private String alphabet;
    private List<String> states;
    private List<String> finalStates;
    private List<Transition> transitions;

    public StateMachine() {
    }

//    public StateMachine(String alphabet, List<String> states, List<String> finalStates, List<Transition> transitions) {
//        this.alphabet = alphabet;
//        this.states = states;
//        this.finalStates = finalStates;
//        this.transitions = transitions;
//    }

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



    private Stack<StateStatus> previousStates = new Stack<>();


    // We start looping from the first state
    private String focusState;

    private StringBuilder word;

    private int currentTransitionIndex = 0;

    public boolean isWordAccepted(String inputWord) {

        focusState = getStates().get(0);

        int transitionsCount = getTransitions().size();

        word = new StringBuilder(inputWord);

        while (currentTransitionIndex < transitionsCount) {

            Transition transition = getTransitions().get(currentTransitionIndex);

            if ((word.charAt(0) + "").equals(transition.getTransitionSymbol()) && focusState.equals(transition.getStateOne())) {

//                if(transition.getStateOne().equals(transition.getStateTwo())){
//
//                }

                // Save the current state for going back, if needed
                StateStatus stateStatus = new StateStatus(focusState, currentTransitionIndex + 1, new StringBuilder(word));
                previousStates.push(stateStatus);

                // Update the current state with new state
                focusState = transition.getStateTwo();

                // Remove a character from the word
                word.deleteCharAt(0);

                currentTransitionIndex = 0;

                if (word.length() == 0 && getFinalStates().contains(focusState)) {
                    return true;
                } else if (word.length() == 0 && !getFinalStates().contains(focusState)) {
                    goOneStateBack();

                }
                continue;

            }
            currentTransitionIndex++;

            // Going one state back
            // If we checked all transition and could find a path to continue
            if ((currentTransitionIndex == transitionsCount)) {
                goOneStateBack();

            }

        }

        return false;

    }

    private void goOneStateBack() {
        if (previousStates.empty()) {
            return;
        }
        StateStatus previousState = previousStates.pop();

        focusState = previousState.getState();
        currentTransitionIndex = previousState.getTransitionIndex();
        word = previousState.getWord();
    }


}