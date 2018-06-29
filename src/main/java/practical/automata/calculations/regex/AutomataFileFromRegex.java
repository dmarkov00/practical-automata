package practical.automata.calculations.regex;

import practical.automata.calculations.regex.structures.Node;
import practical.automata.calculations.regex.structures.RegexTree;
import practical.automata.calculations.utils.Utils;
import practical.automata.models.AutomataFileFromRegexResult;
import practical.automata.models.Regex;

import java.util.ArrayList;
import java.util.List;

public class AutomataFileFromRegex {

    private RegexTree regexTree;


    public AutomataFileFromRegex(Regex regex) {
        RegexReader regexReader = new RegexReader();

        this.regexTree = regexReader.readRegex(regex);

    }

    public AutomataFileFromRegexResult generateFile() {

        return null;
    }

    /**
     * The algorithm is base on binary tree evaluation
     *
     * @return A list of transitions strings that are later written to a file
     */
    private List<String> generateTransitionsFromTree(int rootIndex, Node[] arrayTree) {
        if (!regexTree.nodeHasLeftChild(rootIndex) & !regexTree.nodeHasRightChild(rootIndex)) {

            return arrayTree[rootIndex].getTransitions();
        }
        List<String> leftNandifiedValue;
        List<String> rightNandifiedValue;

        if (!regexTree.nodeHasLeftChild(rootIndex)) {
            leftNandifiedValue = null;
        } else {
            leftNandifiedValue = generateTransitionsFromTree(regexTree.getLeftChildIndex(rootIndex), arrayTree);
        }
        if (!regexTree.nodeHasRightChild(rootIndex)) {
            rightNandifiedValue = null;
        } else {
            rightNandifiedValue = generateTransitionsFromTree(regexTree.getRightChildIndex(rootIndex), arrayTree);
        }

        if (Utils.isOperator(arrayTree[rootIndex])) {
            List<String> transitionsValue = extractTransitions(arrayTree[rootIndex], leftNandifiedValue, rightNandifiedValue);
            arrayTree[rootIndex].setTransitions(transitionsValue);

            return transitionsValue;
        }
        return arrayTree[rootIndex].getTransitions();
    }

    /**
     * Generates result based on the operator and the passed left and right variables
     */
    private List<String> extractTransitions(Node root, List<String> left, List<String> right) {

        List<String> transitionsResult = new ArrayList<>();
        char rootValue = root.getValue();

        String lastState = null; // used to track the most outer state of the state machine

        switch (rootValue) {

            case '|':

                String stateOnePipe = Utils.generateUniqueState();
                String stateTwoPipe = Utils.generateUniqueState();

                transitionsResult.add(stateOnePipe + "," + left + "-->" + stateTwoPipe);
                transitionsResult.add(stateTwoPipe + "," + right + "-->" + stateOnePipe);
            case '.': // For this case it is required to generate 3 states

                String stateOneDot = null;
                String stateTwoDot = Utils.generateUniqueState();
                String stateThreeDot = Utils.generateUniqueState();

                if (lastState != null) {
                    stateOneDot = lastState;
                } else {
                    stateOneDot = Utils.generateUniqueState();

                }
                lastState = stateThreeDot;


                transitionsResult.add(stateOneDot + "," + left + "-->" + stateTwoDot);
                transitionsResult.add(stateTwoDot + "," + right + "-->" + stateThreeDot);
            case '*':
                String stateOneAsterisk = Utils.generateUniqueState();
                String stateTwoAsterisk = Utils.generateUniqueState();
                String stateThreeAsterisk = Utils.generateUniqueState();
                String stateFourAsterisk = Utils.generateUniqueState();

                transitionsResult.add(stateOneAsterisk + "," + "_" + "-->" + stateTwoAsterisk);

                transitionsResult.add(stateThreeAsterisk + "," + "_" + "-->" + stateFourAsterisk);

                transitionsResult.add(stateFourAsterisk + "," + "_" + "-->" + stateTwoAsterisk);

                transitionsResult.add(stateOneAsterisk + "," + "_" + "-->" + stateFourAsterisk);


                if (right == null) {
                    transitionsResult.add(stateTwoAsterisk + "," + left + "-->" + stateFourAsterisk);

                } else if (left == null) {
                    transitionsResult.add(stateTwoAsterisk + "," + right + "-->" + stateFourAsterisk);
                }

                return transitionsResult;


        }
        return null;
    }


    public void writeResultToFile(List<String> generatedTransitions) {

    }


}
