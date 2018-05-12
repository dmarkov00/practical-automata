package practical.automata.calculations.utils;

import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.Transition;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class StateMachineImage {
    public static void generateImage(StateMachine stateMachine) {
        // Used to check when to put double circle or just circle
        String circleOutline;


        List<String> lines = new ArrayList<>();
        lines.add("digraph myAutomaton {");
        lines.add("rankdir=LR;");
        lines.add("\"\" [shape=none]\n");

        for (String state : stateMachine.getStates()) {
            if (stateMachine.getFinalStates().contains(state)) {
                circleOutline = "doublecircle";

            } else {
                circleOutline = "circle";
            }

            lines.add("\"" + state + "\""+ " [shape=" + circleOutline + "]");
        }
        // Add the initial the first initial state
        lines.add("\"\" -> " + "\"" + stateMachine.getStates().get(0) + "\"");

        for (Transition transition : stateMachine.getTransitions()) {
            lines.add("\"" + transition.getStateOne() + "\" -> " + "\"" + transition.getStateTwo() + "\""
                    + "[label=" + "\"" + transition.getTransitionSymbol() + "\"] ");

        }

        lines.add("}");

        Path out = Paths.get("graph.dot");

        try {
            Files.write(out, lines, Charset.defaultCharset());
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            Process p = Runtime.getRuntime().exec("dot -Tpng -ograph.png graph.dot");
            try {
                p.waitFor();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
