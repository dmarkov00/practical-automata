package practical.automata.calculations;

import practical.automata.calculations.indicate_dfa.DfaIndicator;
import practical.automata.calculations.structures.StateMachineFile;
import practical.automata.calculations.utils.StateMachineFileReader;
import practical.automata.calculations.word_acceptance.WordAcceptance;


/**
 * Works as a entry point or a facade for all of functionality the application provides
 * When initialized it reads the latest file from the filesystem, sets private StateMachineFile object (which is the file converted to java object)
 */
public class CalculationsManager {

    public CalculationsManager() {
        InitializeValuesFromFile();
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

    private void InitializeValuesFromFile() {

        StateMachineFileReader stateMachineFileReader = new StateMachineFileReader();

        // Reads the file from the system and generates StateMachineFile object
        this.stateMachineFile = stateMachineFileReader.readStateMachineFile();

    }

}
