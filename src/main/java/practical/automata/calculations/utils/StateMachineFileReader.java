package practical.automata.calculations.utils;

import practical.automata.calculations.structures.StateMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class StateMachineFileReader {
    private StateMachine stateMachine = new StateMachine();


    public void readAutomataFile() {

        List<String> fileLines = generateListWithFileLines();
        Map<String, List<String>> transitions = new HashMap<>();

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
                    Map<String, List<String>> transition = this.extractTransition(fileLines.get(transitionsIndex));
                    transitions.putAll(transition);
                    transitionsIndex++;
                }
                break;
            }
        }
        stateMachine.setTransitions(transitions);
    }

    private Map<String, List<String>> extractTransition(String line) {
        String firstState = null;
        String secondState = null;
        String transitionSymbol = null;

        Map<String, List<String>> transition = new HashMap<>();

        for (char symbol : line.toCharArray()) {

            if (Character.isUpperCase(symbol)) {
                if (firstState == null) {
                    firstState = symbol + "";

                } else {
                    secondState = symbol + "";
                }
            } else if (Character.isLowerCase(symbol) || symbol == '_') {
                transitionSymbol = symbol + "";
            }
        }
        ArrayList<String> transitionStates = new ArrayList<String>();
        transitionStates.add(firstState);
        transitionStates.add(secondState);

        transition.put(transitionSymbol, transitionStates);

        return transition;
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

}
