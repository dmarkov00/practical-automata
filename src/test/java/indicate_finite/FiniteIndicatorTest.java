package indicate_finite;

import org.junit.Test;
import practical.automata.calculations.CalculationsManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class FiniteIndicatorTest {
    private CalculationsManager calculationsManager = new CalculationsManager(null);

    @Test
    public void indicateFiniteWithNotFiniteFile1() {

        // Set the file we want to test with
        calculationsManager.InitializeValuesFromFile("./src/test/resources/indicate_finite/dfa-not-finite1.txt");

        // The method should be retuning a null when the automaton is not finite
        List<String> generatedWords = calculationsManager.indicateFinite();

        assertNull(generatedWords);

    }

    @Test
    public void indicateFiniteWithNotFiniteFile2() {

        // Set the file we want to test with
        calculationsManager.InitializeValuesFromFile("./src/test/resources/indicate_finite/dfa-not-finite2.txt");

        // The method should be retuning a null when the automaton is not finite
        List<String> generatedWords = calculationsManager.indicateFinite();

        assertNull(generatedWords);

    }

    @Test
    public void indicateFiniteWithNotFiniteFile3() {

        // Set the file we want to test with
        calculationsManager.InitializeValuesFromFile("./src/test/resources/indicate_finite/dfa-not-finite3.txt");

        // The method should be retuning a null when the automaton is not finite
        List<String> generatedWords = calculationsManager.indicateFinite();

        assertNull(generatedWords);

    }

    @Test
    public void indicateFiniteWithFiniteAutomatonFile1() {

        // Set the file we want to test with
        calculationsManager.InitializeValuesFromFile("./src/test/resources/indicate_finite/not-dfa-finite.txt");

        // The method should be retuning a null when the automaton is not finite
        List<String> generatedWords = calculationsManager.indicateFinite();

        List<String> expectedGeneratedWords = new ArrayList<>(Arrays.asList("ab", "aab", "aaa", "baa", "bab", "bb", "ca", "cb"));


        assertTrue(generatedWords.containsAll(expectedGeneratedWords));

    }
}
