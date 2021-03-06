package practical.automata.calculations.utils;

import practical.automata.calculations.structures.StateMachineFile;
import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.TestVector;
import practical.automata.calculations.structures.Transition;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StateMachineFileReader {
    private StateMachine stateMachine = new StateMachine();
    private TestVector testVector = new TestVector();

    public static String filePath = "./file.txt"; // Easily accessible file path, that can be set from outside
    // Used to store the index of the line, and avoid repetitive looping
    private int lineIndex;


    public StateMachineFile readStateMachineFile() {

        List<String> fileLines = generateListWithFileLines();

        // Set the the data inside the StateMachine object
        extractStateMachineData(fileLines);

        // Set the the data inside the TestVector object
//        extractTestVectorData(fileLines);

        return new StateMachineFile(stateMachine, testVector);
    }

    /**
     * Reads every line from the file and inserts it into a list of strings
     *
     * @return list of string file lines
     */
    private List<String> generateListWithFileLines() {

//        String FILE_PATH = "./test.txt"; // The path is always the same just the file is replaced when a new one is read
        String FILE_PATH = filePath;

        Scanner sc = null;
        try {
            sc = new Scanner(new File(FILE_PATH));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<String> lines = new ArrayList<String>();
        while (sc.hasNextLine()) {
            lines.add(sc.nextLine());
        }
        sc.close();

        return lines;
    }

    /**
     * Gets a string transition line as an input and returns an object
     */
    private Transition extractTransition(String line) {
        String stateOne = null;
        String stateTwo = null;
        String transitionSymbol = null;


        for (char symbol : line.toCharArray()) {

            if (Character.isUpperCase(symbol)) {
                if (stateOne == null) {
                    stateOne = symbol + "";

                } else {
                    stateTwo = symbol + "";
                }
            } else if (Character.isLowerCase(symbol) || symbol == '_') {
                transitionSymbol = symbol + "";
            }
        }

        return new Transition(transitionSymbol, stateOne, stateTwo);
    }

    /**
     * Gets all the states and fills them into a list, by only taking the uppercase symbols
     */
    private List<String> extractStates(String line) {
        List<String> extractedStates = new ArrayList<>();

        for (char symbol : line.toCharArray()) {

            if (Character.isUpperCase(symbol)) {
                extractedStates.add(symbol + "");
            }
        }

        return extractedStates;
    }


    private void extractTestVectorData(List<String> fileLines) {

        Map<String, String> wordAndResultMap = new HashMap<>();

        int testVectorLineIndex = lineIndex + 1;

        while (!fileLines.get(testVectorLineIndex).contains("end") && testVectorLineIndex < fileLines.size()) {

            if (fileLines.get(testVectorLineIndex).contains("dfa")) {

                testVector.setDFA(extractValueAfterColon(fileLines.get(testVectorLineIndex)));

            } else if (fileLines.get(testVectorLineIndex).contains("indicate_finite")) {
                testVector.setFinite(extractValueAfterColon(fileLines.get(testVectorLineIndex)));

                // If the line contains a come it means that is part of words in the test vectors
            } else if (fileLines.get(testVectorLineIndex).contains(",")) {
                String wordAndResultArray[] = fileLines.get(testVectorLineIndex).split(",");
                wordAndResultMap.put(wordAndResultArray[0], wordAndResultArray[1]);

            }
            testVectorLineIndex++;

        }
        testVector.setWords(wordAndResultMap);
    }

    /**
     * Gets the data from the state machine like alphabet, states... and extracts transitions until it reaches the "end" keyword
     */
    private void extractStateMachineData(List<String> fileLines) {
        List<Transition> transitions = new ArrayList<>();

        for (int i = 0; i < fileLines.size() - 1; i++) {

            if (fileLines.get(i).contains("alphabet")) {
                stateMachine.setAlphabet(extractValueAfterColon(fileLines.get(i)));

            } else if (fileLines.get(i).contains("states")) {
                List<String> states = this.extractStates(fileLines.get(i));
                stateMachine.setStates(states);

            } else if (fileLines.get(i).contains("final")) {

                List<String> states = this.extractStates(fileLines.get(i));
                stateMachine.setFinalStates(states);
            } else if (fileLines.get(i).contains("transitions")) {

                int transitionsIndex = i + 1;
                while (!fileLines.get(transitionsIndex).contains("end")) {
                    Transition transition = this.extractTransition(fileLines.get(transitionsIndex));
                    transitions.add(transition);
                    transitionsIndex++;
                }
                // Making lineIndex the last looped index
                lineIndex = transitionsIndex;
                break;
            }
        }
        stateMachine.setTransitions(transitions);
    }

    /**
     * Gets the value after the ':' sign
     */
    private String extractValueAfterColon(String line) {

        return line.substring(line.lastIndexOf(":") + 1).replaceAll("[\\s:+]", "");
    }


}
