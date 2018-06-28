package practical.automata.calculations.regex;

import practical.automata.calculations.regex.structures.Node;
import practical.automata.calculations.regex.structures.RegexTree;
import practical.automata.calculations.utils.Utils;
import practical.automata.models.AutomataFileFromRegexResult;
import practical.automata.models.Regex;

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

    private List<String> extractTransitions(Node root, List<String> left, List<String> right) {

    }


    public void writeResultToFile(List<String> generatedTransitions) {

    }


}
