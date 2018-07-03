package practical.automata.calculations.finite;

import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.StateMachineFile;
import practical.automata.calculations.structures.Transition;
import practical.automata.calculations.utils.StateMachineFileReader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FiniteIndicator {

    public List<String> indicateFinite() {

        // First, read the latest file in the system and return the read data
        StateMachineFileReader stateMachineFileReader = new StateMachineFileReader();
        StateMachineFile stateMachineFile = stateMachineFileReader.readStateMachineFile();

        List<State> states = generateStateData(stateMachineFile.getStateMachine());


        return generateWords(states);
    }

    /**
     * Converts a StateMachine object into a list of State objects, the State object is setup in a way suitable for the word generation algorithm
     */
    private List<State> generateStateData(StateMachine stateMachine) {
//        List

        for (String state : stateMachine.getStates()) {

            for (Transition trans : stateMachine.getTransitions()) {
                if (state == trans.getStateTwo()) {

                }
            }

        }


        return null;
    }



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
