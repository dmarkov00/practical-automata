package practical.automata.calculations.word_acceptance;

import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.Transition;

import java.util.Stack;

public class WordAcceptance {
    
    public WordAcceptance(StateMachine stateMachine) {

        this.stateMachine = stateMachine;
    }

    private StateMachine stateMachine;

    // Stores states in case the algorithm needs to go back in the state machine graph
    private Stack<StateStatus> previousStates = new Stack<>();

    private String focusState;

    private StringBuilder word;

    private int currentTransitionIndex = 0;

    /**
     * The main method that goes through all states and checks if a words is accepted
     */
    public boolean isWordAccepted(String inputWord) {

        // Start looping from the first state
        focusState = stateMachine.getStates().get(0);

        // Use transitions as a pointer when to stop looping
        int transitionsCount = stateMachine.getTransitions().size();

        // Start from the test input word and gradually remove characters until they are all removed and word is accepted
        word = new StringBuilder(inputWord);

        while (currentTransitionIndex < transitionsCount) {

            Transition transition = stateMachine.getTransitions().get(currentTransitionIndex);


            // Check if the first symbol of the passed word is equal the transition symbol of the transition
            // && if the focus state is equal to the first state of the transition
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

                currentTransitionIndex = 0; // Start looping all transition from the beginning

                if (word.length() == 0 && stateMachine.getFinalStates().contains(focusState)) {
                    return true;
                } else if (word.length() == 0 && !stateMachine.getFinalStates().contains(focusState)) {
                    goOneStateBack();

                }
                continue;

            }
            currentTransitionIndex++;

            // Going one state back
            // If we checked all transition and couldn't find a path to continue
            if ((currentTransitionIndex == transitionsCount)) {
                goOneStateBack();

            }

        }

        return false;

    }

    /**
     * Pops a state from the stack and sets tha values it has to the class variables
     */
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
