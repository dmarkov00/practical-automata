package practical.automata.calculations.structures;


public class Transition {
    private String transitionSymbol;
    private String stateOne;
    private String stateTwo;

    public Transition(String transitionSymbol, String stateOne, String stateTwo) {
        this.transitionSymbol = transitionSymbol;
        this.stateOne = stateOne;
        this.stateTwo = stateTwo;
    }

    public String getTransitionSymbol() {
        return transitionSymbol;
    }

    public void setTransitionSymbol(String transitionSymbol) {
        this.transitionSymbol = transitionSymbol;
    }

    public String getStateOne() {
        return stateOne;
    }

    public void setStateOne(String stateOne) {
        this.stateOne = stateOne;
    }

    public String getStateTwo() {
        return stateTwo;
    }

    public void setStateTwo(String stateTwo) {
        this.stateTwo = stateTwo;
    }


}
