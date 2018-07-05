package practical.automata.calculations;

import practical.automata.calculations.indicate_dfa.DfaIndicator;
import practical.automata.calculations.ndfa_to_dfa.NdfaToDfaConverter;
import practical.automata.calculations.structures.StateMachineFile;
import practical.automata.calculations.utils.StateMachineFileReader;
import practical.automata.calculations.word_acceptance.WordAcceptance;
import practical.automata.models.NdfaFromRegexResult;


/**
 * Works as a entry point or a facade for all of functionality the application provides
 * When initialized it reads the latest file from the filesystem, sets private StateMachineFile object (which is the file converted to java object)
 */
public class CalculationsManager {

    public CalculationsManager(String filePath) {
        InitializeValuesFromFile(filePath);
    }

    private StateMachineFile stateMachineFile;

    /**
     * Checks if a the read state machine is a dfa
     */
    public boolean indicateDFA() {
        DfaIndicator dfaIndicator = new DfaIndicator(stateMachineFile.getStateMachine());

        return dfaIndicator.checkForDFA();
    }

    /**
     * Check if the passed word is accepted by the state machine
     */
    public boolean isWordAccepted(String word) {
        WordAcceptance wordAcceptance = new WordAcceptance(stateMachineFile.getStateMachine());

        return wordAcceptance.isWordAccepted(word);

    }


    public NdfaFromRegexResult generateNdfaFromRegex() {
        // TODO: update the method to call the ndfa_from_regex package

        return null;
    }

    public void convertNdfaToDfa() {
        NdfaToDfaConverter ndfaToDfaConverter = new NdfaToDfaConverter(stateMachineFile.getStateMachine());

        ndfaToDfaConverter.convertNdfaToDfa();

    }

    public void InitializeValuesFromFile(String filePath) {


        StateMachineFileReader stateMachineFileReader = new StateMachineFileReader();
        if (filePath != null) {
            StateMachineFileReader.filePath = filePath;
        }

        // Reads the file from the system and generates StateMachineFile object
        this.stateMachineFile = stateMachineFileReader.readStateMachineFile();

    }

}
