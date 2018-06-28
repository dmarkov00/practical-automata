package practical.automata.calculations.regex;

import practical.automata.calculations.regex.structures.RegexTree;
import practical.automata.models.AutomataFileFromRegexResult;
import practical.automata.models.Regex;

public class AutomataFileFromRegex {

    private RegexTree regexTree;


    public AutomataFileFromRegex(Regex regex) {
        RegexReader regexReader = new RegexReader();

        this.regexTree = regexReader.readRegex(regex);

    }

    public AutomataFileFromRegexResult generateFile() {

        return null;
    }


}
