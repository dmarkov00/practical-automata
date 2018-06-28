package practical.automata.models;

/**
 * I need to have this dummy class, instead of just String because of the way Spring framework works,
 * when JSON is received Spring needs to parse it to some object in order to retrieve the data
 */
public class Regex {
    private String regex;

    public Regex(String regex) {

        this.regex = regex;
    }

    public String getRegex() {
        return regex;
    }

    public void setRegex(String regex) {
        this.regex = regex;
    }

}
