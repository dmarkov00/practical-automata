package practical.automata.calculations.indicate_dfa;

import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.Transition;
import practical.automata.calculations.utils.Utils;

import java.util.ArrayList;
import java.util.List;

public class DfaIndicator {

    public DfaIndicator(StateMachine stateMachine) {
        this.stateMachine = stateMachine;
    }

    private StateMachine stateMachine;

    public boolean checkForDFA() {

        List<String> uniqueTransitions = new ArrayList<>();

        List<String> alphabet = Utils.convertStringToListOfStringCharacters(stateMachine.getAlphabet());

        boolean isDFA = false;

        for (String state : stateMachine.getStates()) {
            for (Transition transition : stateMachine.getTransitions()) {
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
}
