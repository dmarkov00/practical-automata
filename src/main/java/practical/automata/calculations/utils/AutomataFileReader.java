package practical.automata.calculations.utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AutomataFileReader {

    public void readAutomataFile() {
        List<String> fileLines = generateListWithFileLines();


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
