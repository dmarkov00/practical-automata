package practical.automata.calculations.structures;

import java.util.List;
import java.util.Map;

public class TestVector {
    boolean DFA;
    boolean finite;
    List<Map<String, Boolean>> words;

    public boolean isDFA() {
        return DFA;
    }

    public void setDFA(boolean DFA) {
        this.DFA = DFA;
    }

    public boolean isFinite() {
        return finite;
    }

    public void setFinite(boolean finite) {
        this.finite = finite;
    }

    public List<Map<String, Boolean>> getWords() {
        return words;
    }

    public void setWords(List<Map<String, Boolean>> words) {
        this.words = words;
    }
}
