package practical.automata.calculations.ndfa_from_regex;

import practical.automata.calculations.ndfa_from_regex.structures.RegexTree;
import practical.automata.models.Regex;

import java.io.UnsupportedEncodingException;

public class RegexReader {

    private RegexTree regexTree;

    public RegexReader() {
        this.regexTree = new RegexTree();
    }


    public RegexTree readRegex(Regex regex) {

        StringBuilder convertedRegex = this.convertRegex(regex);

        if (convertedRegex != null) {
            readConvertedRegex(convertedRegex);

        } else return null;

        return regexTree;
    }

    // Read ndfa_from_regex with recursion
    private void readConvertedRegex(StringBuilder regex) {
        regexTree.addNode(regex.charAt(0));

        regex.deleteCharAt(0);

        if (regex.length() == 0) {
            return;
        }

        readConvertedRegex(regex);
    }

    /**
     * This method is required because the Regex is received via http and some special symbols need decoding
     */
    private StringBuilder convertRegex(Regex regex) {

        String parsedRegex = "";
        String notParsedRegex = regex.getRegex();
        try {
            StringBuilder tempBuffer = new StringBuilder();
            int incrementer = 0;
            int dataLength = notParsedRegex.length();
            while (incrementer < dataLength) {
                char characterAt = notParsedRegex.charAt(incrementer);

                // Necessary fix, when % signs are sent
                if (characterAt == '%') {
                    tempBuffer.append("<percentage>");
                } else {
                    tempBuffer.append(characterAt);
                }
                incrementer++;
            }
            notParsedRegex = tempBuffer.toString();

            parsedRegex = java.net.URLDecoder.decode(notParsedRegex, "UTF-8").replaceAll("<percentage>", "%");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        // Remove spaces
        String trimmedRegex = parsedRegex.replaceAll("\\s", "");

        if (isRegexCorrectlyFormatted(trimmedRegex)) {
            return new StringBuilder(trimmedRegex);

        } else return null;
    }

    /**
     * Checks if the regular expression meets the requirements by using another regular expression
     */
    private boolean isRegexCorrectlyFormatted(String regexStr) {

        return regexStr.matches("[a-zA-Z()*|._,]+");
    }

}
