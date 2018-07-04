package practical.automata.calculations.word_acceptance;

import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.Transition;

import java.util.Stack;

public class WordAcceptance {
    
    public WordAcceptance(StateMachine stateMachine) {

        this.stateMachine = stateMachine;
    }

    private StateMachine stateMachine;

    private Stack<StateStatus> previousStates = new Stack<>();


    // We start looping from the first state
    private String focusState;

    private StringBuilder word;

    private int currentTransitionIndex = 0;

    public boolean isWordAccepted(String inputWord) {

        focusState = stateMachine.getStates().get(0);

        int transitionsCount = stateMachine.getTransitions().size();

        word = new StringBuilder(inputWord);

        while (currentTransitionIndex < transitionsCount) {

            Transition transition = stateMachine.getTransitions().get(currentTransitionIndex);

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

                if (word.length() == 0 && stateMachine.getFinalStates().contains(focusState)) {
                    return true;
                } else if (word.length() == 0 && !stateMachine.getFinalStates().contains(focusState)) {
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
