package practical.automata.calculations.structures;

import java.util.List;
import java.util.Map;

public class TestVector {
    private String DFA;
    private String finite;
    private List<Map<String, Boolean>> words;

    public String isDFA() {
        return DFA;
    }

    public void setDFA(String DFA) {
        this.DFA = DFA;
    }

    public String isFinite() {
        return finite;
    }

    public void setFinite(String finite) {
        this.finite = finite;
    }

    public List<Map<String, Boolean>> getWords() {
        return words;
    }

    public void setWords(List<Map<String, Boolean>> words) {
        this.words = words;
    }
}
