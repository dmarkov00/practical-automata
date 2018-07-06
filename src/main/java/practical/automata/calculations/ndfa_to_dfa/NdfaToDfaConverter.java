package practical.automata.calculations.ndfa_to_dfa;

import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.Transition;
import practical.automata.calculations.utils.Utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NdfaToDfaConverter {
    public NdfaToDfaConverter(StateMachine ndfaStateMachine) {
        this.ndfaStateMachine = ndfaStateMachine;
    }

    private StateMachine ndfaStateMachine;
    private List<List<String>> states;


    public void convertNdfaToDfa() {

        List<ConverterTableRow> converterTableRowList = generateConverterTableRows();

//        StateMachine dfaStateMachine = generateStateMachineFromConverterTableRows(converterTableRowList);

//        StateMachineImage.generateImage(dfaStateMachine);

    }

    private List<ConverterTableRow> generateConverterTableRows() {
        List<ConverterTableRow> tableRows = new ArrayList<>();
        this.convertStatesIntoListOfStates();

        for (List<String> state : states) {

            ConverterTableRow converterTableRow = new ConverterTableRow();

            // Set the state in the row
            converterTableRow.setState(state);

            // Gets the alphabet and converts it into a list of strings
            List<String> alphabet = Utils.convertStringToListOfStringCharacters(ndfaStateMachine.getAlphabet());

            Map<String, List<String>> transitionSymbolToCorrelationStatesMap = new HashMap<>();

//            transitionSymbolToCorrelationStatesMap
            for (String transitionSymbol : alphabet) {
                List<String> correlationStates = new ArrayList<>();


                boolean stateHasTransitionSymbol = false;
                for (Transition trans : ndfaStateMachine.getTransitions()) {

                    if (transitionSymbol.equals(trans.getTransitionSymbol()) && state.equals(trans.getStateOne())) {
                        correlationStates.add(trans.getStateTwo());
                        stateHasTransitionSymbol = true;
                    }
                }

                if (stateHasTransitionSymbol) {
                    transitionSymbolToCorrelationStatesMap.put(transitionSymbol, correlationStates);

                }

            }


            converterTableRow.setTransitionSymbolToCorrelationStatesMap(transitionSymbolToCorrelationStatesMap);

            tableRows.add(converterTableRow);

            for (List<String> correlationState : converterTableRow.getTransitionSymbolToCorrelationStatesMap().values()) {
                this.states.add(correlationState);

            }

        }
        return tableRows;

    }

    private StateMachine generateStateMachineFromConverterTableRows(List<ConverterTableRow> converterTableRows) {
        return null;
    }

    /**
     * Converts List<String> to List<List<String>>  with states, needed for the algorithm
     */
    public void convertStatesIntoListOfStates() {
        List<List<String>> states = new ArrayList<>();
        for (String state : ndfaStateMachine.getStates()) {

            // Convert state into a list of state, so it fits with the rest of the algorithm
            List<String> listState = new ArrayList<>();
            listState.add(state);

            states.add(listState);
        }
        this.states = states;
    }
}
