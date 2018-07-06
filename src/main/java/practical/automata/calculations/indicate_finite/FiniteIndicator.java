package practical.automata.calculations.indicate_finite;

import practical.automata.calculations.structures.StateMachine;

import practical.automata.calculations.structures.Transition;


import java.util.ArrayList;
import java.util.List;

public class FiniteIndicator {

    public List<String> indicateFinite(StateMachine stateMachine) {


        this.stateMachine = stateMachine;

        return generateWords();
    }

    private StateMachine stateMachine;

    /**
     * Converts a StateMachine object into a list of State objects, the State object is setup in a way suitable for the word generation algorithm
     */
    private List<State> generateStateData(StateMachine stateMachine) {
        //TODO Generate states data and fill in the  List<State> object

        for (String state : stateMachine.getStates()) {

            for (Transition trans : stateMachine.getTransitions()) {
                if (state == trans.getStateTwo()) {

                }
            }

        }


        return null;
    }

    private List<String> generateWords() {
        //TODO pass as a list of states properly
//        List<State> states = null;
//        // We begin with the initial state of the automaton
//        List<State> focusStates = new ArrayList<>();
//
////        focusStates.add(states.get(0));
//        for (State state : states) {
//
//        }
        return null;
    }

    /**
     *
     */
    private List<State> generateNewFocuStates(List<State> focusStates) {

        List<State> newFocusStates = new ArrayList<>();


        for (State focusState : focusStates) {

            for (State outputState : focusState.getOutputStates()) {

                String updatedWord = outputState.getWord() + focusState.getWord();
                outputState.setWord(updatedWord);
                newFocusStates.add(outputState);
            }
        }

        return newFocusStates;
    }


}
