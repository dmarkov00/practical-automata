import org.junit.Test;
import practical.automata.calculations.utils.Utils;

public class UtilsTest {

    @Test
    public void generateUniqueStatesTest() {
        for (int i = 0; i < 100; i++) {
        String a = Utils.generateUniqueState();
            System.out.println(a);

        }
    }
}
