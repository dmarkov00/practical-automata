package utils;

import org.junit.Test;
import practical.automata.calculations.utils.Utils;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class UtilsTest {

    @Test
    public void generateUniqueStatesForTheTenthCallOfTheMethod() {

        String stateName = null;
        for (int i = 0; i < 10; i++) {
            stateName = Utils.generateUniqueState();

        }

        assertThat(stateName, is("J"));
    }

    /**
     *  Expected B2 because I am using 24 letters of the alphabet (without R and T) -> i.e. A,B,C...A1,B1....,A2,B2
     */

    @Test
    public void generateUniqueStatesForTheFiftiethCallOfTheMethod() {

        String stateName = null;
        for (int i = 0; i < 50; i++) {
            stateName = Utils.generateUniqueState();

        }

        assertThat(stateName, is("B2"));
    }
}
