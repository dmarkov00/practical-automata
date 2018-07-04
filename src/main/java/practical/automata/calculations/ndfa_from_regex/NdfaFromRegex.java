package practical.automata.calculations.ndfa_from_regex;

import practical.automata.calculations.ndfa_from_regex.structures.Node;
import practical.automata.calculations.ndfa_from_regex.structures.RegexTree;
import practical.automata.calculations.structures.StateMachine;
import practical.automata.calculations.structures.Transition;
import practical.automata.calculations.utils.Utils;
import practical.automata.models.NdfaFromRegexResult;
import practical.automata.models.Regex;

import java.util.ArrayList;
import java.util.List;

public class NdfaFromRegex {

    private RegexTree regexTree;


    public NdfaFromRegex(Regex regex) {
        RegexReader regexReader = new RegexReader();

        this.regexTree = regexReader.readRegex(regex);

    }

    public NdfaFromRegexResult generateFile() {

        Node[] arrayTree = regexTree.getArrayTree();

        List<Transition> generatedTransiotions = generateTransitionsFromTree(0, arrayTree);

        StateMachine stateMachine = new StateMachine();


        return null;
    }

    /**
     * The algorithm is base on binary tree evaluation
     *
     * @return A list of transitions strings that are later written to a file
     */
    private List<Transition> generateTransitionsFromTree(int rootIndex, Node[] arrayTree) {
        if (!regexTree.nodeHasLeftChild(rootIndex) & !regexTree.nodeHasRightChild(rootIndex)) {

            return arrayTree[rootIndex].getTransitions();
        }
        List<Transition> left;
        List<Transition> right;

        if (!regexTree.nodeHasLeftChild(rootIndex)) {
            left = null;
        } else {
            left = generateTransitionsFromTree(regexTree.getLeftChildIndex(rootIndex), arrayTree);
        }
        if (!regexTree.nodeHasRightChild(rootIndex)) {
            right = null;
        } else {
            right = generateTransitionsFromTree(regexTree.getRightChildIndex(rootIndex), arrayTree);
        }

        if (Utils.isOperator(arrayTree[rootIndex])) {
            List<Transition> transitionsValue = extractTransitions(arrayTree[rootIndex], left, right);
            arrayTree[rootIndex].setTransitions(transitionsValue);

            return transitionsValue;
        }
        return arrayTree[rootIndex].getTransitions();
    }


    private String lastState = null; // used to track the most outer state of the state machine
    private String firstState = null;
    private String leftTransitionSymbol;
    private String rightTransitionSymbol;

    /**
     * Generates result based on the operator and the passed left and right variables
     */
    private List<Transition> extractTransitions(Node root, List<Transition> left, List<Transition> right) {

        List<String> transitionsResult = new ArrayList<>();
        char rootValue = root.getValue();


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

                if (lastState != null) {
                    transitionsResult.add(lastState + "," + "_" + "-->" + stateOneAsterisk);
                    transitionsResult.add(stateOneAsterisk + "," + "_" + "-->" + lastState);
                }

                transitionsResult.add(stateOneAsterisk + "," + "_" + "-->" + stateTwoAsterisk);

                transitionsResult.add(stateThreeAsterisk + "," + "_" + "-->" + stateFourAsterisk);

                transitionsResult.add(stateFourAsterisk + "," + "_" + "-->" + stateTwoAsterisk);

                transitionsResult.add(stateOneAsterisk + "," + "_" + "-->" + stateFourAsterisk);


                if (right == null) {
                    transitionsResult.add(stateTwoAsterisk + "," + left + "-->" + stateFourAsterisk);

                } else if (left == null) {
                    transitionsResult.add(stateTwoAsterisk + "," + right + "-->" + stateFourAsterisk);
                }

//                return transitionsResult;
                return null;

        }
        return null;
    }


    public void writeResultToFile(List<String> generatedTransitions) {

    }


}
