package practical.automata.calculations.utils;

import practical.automata.calculations.structures.StateMachine;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StateMachineFileReader {
    private StateMachine stateMachine = new StateMachine();


    public void readAutomataFile() {

        List<String> fileLines = generateListWithFileLines();

        for (String line : fileLines) {
            if (line.contains("alphabet")) {
                this.extractAlphabet(line);

            } else if (line.contains("states")) {
                List<String> states = this.extractStates(line);
                stateMachine.setStates(states);
            } else if (line.contains("final")) {
                List<String> states = this.extractStates(line);
                stateMachine.setFinalStates(states);
            } else if (line.contains("transitions")) {
                this.extractTransitions(line);
            }
        }
    }

    private void extractTransitions(String line) {
        String firstState;
        String secondState;
        String transitionSymbol;


        for (char state : trimmedLine.toCharArray()) {

            extractedStates.add(state + "");
        }

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
