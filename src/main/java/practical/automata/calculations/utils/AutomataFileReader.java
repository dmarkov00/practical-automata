package practical.automata.calculations.utils;

import practical.automata.calculations.structures.Automata;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomataFileReader {
    Automata automata = new Automata();


    public void readAutomataFile() {
        List<String> fileLines = generateListWithFileLines();


        for (String line : fileLines) {
            if (line.contains("states")) {
                this.extractStates(line);
            }
        }
    }

    private void extractStates(String line) {
        List<String> extractedStates = new ArrayList<>();

        String trimmedLine = line.replace("states", "").replaceAll("[\\s:,+]", "");

        for (char state : trimmedLine.toCharArray()) {

            extractedStates.add(state + "");
        }

        automata.setStates(extractedStates);
    }

    private List<String> generateListWithFileLines() {

        String FILE_PATH = "./out/production/resources/dot-files/graph.dot";

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
