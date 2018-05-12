package practical.automata.calculations.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds static, helper methods used all around the project
 */
public class Utils {


    /**
     * Generates a list of of alphabet letters
     */
    public static List<String> splitAlphabetStringIntoList(String alphabet) {
        List<String> alphabetList = new ArrayList<>();

        for (int i = 0; i < alphabet.toCharArray().length; i++) {
            alphabetList.add(alphabet.toCharArray()[i] + "");

        }

        return alphabetList;
    }
}
