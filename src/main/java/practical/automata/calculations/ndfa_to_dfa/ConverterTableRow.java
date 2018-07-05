package practical.automata.calculations.ndfa_to_dfa;

import java.util.List;
import java.util.Map;

public class ConverterTableRow {
    private List<String> state;

    // Map of transition symbols to correlation states
    private Map<String, List<String>> transitionSymbolToCorrelationStatesMap;

    public List<String> getState() {
        return state;
    }

    public void setState(List<String> state) {
        this.state = state;
    }

    public Map<String, List<String>> getTransitionSymbolToCorrelationStatesMap() {
        return transitionSymbolToCorrelationStatesMap;
    }

    public void setTransitionSymbolToCorrelationStatesMap(Map<String, List<String>> transitionSymbolToCorrelationStatesMap) {
        this.transitionSymbolToCorrelationStatesMap = transitionSymbolToCorrelationStatesMap;
    }
}
