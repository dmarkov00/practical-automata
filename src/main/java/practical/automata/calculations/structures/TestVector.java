package practical.automata.calculations.structures;

import java.util.Map;

/**
 * Stores a test vector data
 */
public class TestVector {
    private String DFA;
    private String finite;
    private Map<String, String> words;

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

    public Map<String, String> getWords() {
        return words;
    }

    public void setWords(Map<String, String> words) {
        this.words = words;
    }
}
