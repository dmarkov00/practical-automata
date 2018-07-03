package practical.automata.calculations.utils;

import practical.automata.calculations.regex.structures.Node;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Holds static, helper methods used all around the project
 */
public class Utils {

    // Variables used for generating unique states for assignment 3
    private static int alphabetCharsCounter = -1;
    private static int statesIteration = 0; // if iteration is 1 for example the generated states become A1, B1 and so on
    private static char[] alphabet = "ABCDEFGHIJKLMNOPQSUVWXYZ".toCharArray(); // 24 chars without R and T

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

    public static boolean isOperator(Node node) {
        List<Character> allowedOperators = Arrays.asList('.', '*'); // TODO: add '|'
        return allowedOperators.contains(node.getValue());
    }

    /**
     * It return a unique state name like A,B..A1..A2,B2....
     */
    public static String generateUniqueState() {
        if (alphabetCharsCounter == 23) {
            alphabetCharsCounter = -1; // Reset value
            statesIteration++; // Increase the number to append
        }

        alphabetCharsCounter++;

        if (statesIteration != 0) {
            String statesIterationString = statesIteration + "";
            return alphabet[alphabetCharsCounter] + statesIterationString;
        }


        return alphabet[alphabetCharsCounter] + "";

    }
}