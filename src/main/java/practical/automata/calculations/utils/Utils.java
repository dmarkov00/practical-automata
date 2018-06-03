package practical.automata.calculations.utils;

import java.util.ArrayList;
import java.util.List;

/**
 * Holds static, helper methods used all around the project
 */
public class Utils {


    /**
     * Generates a list of alphabet letters
     */
    public static List<String> convertStringToListOfStringCharacters(String stringWord) {
        List<String> characterList = new ArrayList<>();

        for (int i = 0; i < stringWord.toCharArray().length; i++) {
            characterList.add(stringWord.toCharArray()[i] + "");

        }

        return characterList;
    }
}
