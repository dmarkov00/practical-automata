package practical.automata.calculations.utils;

import practical.automata.calculations.structures.AutomataFile;
import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.TestVector;
import practical.automata.calculations.structures.Transition;


import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StateMachineFileReader {
    private StateMachine stateMachine = new StateMachine();
    private TestVector testVector = new TestVector();

    // Used to store the index of the line, and avoid repetitive looping
    private int lineIndex;

    public void readAutomataFile() {

        List<String> fileLines = generateListWithFileLines();

        // Set the the data inside the StateMachine object
        extractStateMachineData(fileLines);

        // Set the the data inside the TestVector object
        extractTestVectorData(fileLines);

        AutomataFile automataFile = new AutomataFile(stateMachine, testVector);

    }


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


    private void extractAlphabet(String line) {
        String alphabet = line.replace("alphabet", "").replaceAll("[\\s:+]", "");

        stateMachine.setAlphabet(alphabet);
    }

    private List<String> extractStates(String line) {
        List<String> extractedStates = new ArrayList<>();

        for (char symbol : line.toCharArray()) {

            if (Character.isUpperCase(symbol)) {
                extractedStates.add(symbol + "");
            }
        }

        return extractedStates;
    }

    private List<String> generateListWithFileLines() {

        String FILE_PATH = "./test.dot";

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

    private void extractTestVectorData(List<String> fileLines) {
    }

    private void extractStateMachineData(List<String> fileLines) {
        List<Transition> transitions = new ArrayList<>();

        for (int i = 0; i < fileLines.size() - 1; i++) {

            if (fileLines.get(i).contains("alphabet")) {
                this.extractAlphabet(fileLines.get(i));

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
                break;
            }
        }
        stateMachine.setTransitions(transitions);
    }
}
