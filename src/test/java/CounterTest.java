import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

/**
 * Test class
 */
public class CounterTest {
    private final LettersCounter lettersCounter;

    /**
     * Class constructor with specified array of chars
     */
    public CounterTest() {
        char[] logic_chars = {'l','o','g','i','c'};
        this.lettersCounter = new LettersCounter(logic_chars);
    }

    /**
     * Test if app prints correctly
     */
    @Test
    public void testIfPrints(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String example = "I love to work in global logic!";
        lettersCounter.calculateLOGICLetters(example);

        String expected = "{(i), 1} = 0.07 (1/15)\n" +
                "{(i), 2} = 0.07 (1/15)\n" +
                "{(o), 2} = 0.07 (1/15)\n" +
                "{(o), 4} = 0.07 (1/15)\n" +
                "{(l, o), 4} = 0.13 (2/15)\n" +
                "{(l, o, g), 6} = 0.27 (4/15)\n" +
                "{(l, o, g, i, c), 5} = 0.33 (5/15)\n" +
                "TOTAL Frequency: 0.63 (15/24)";
        Assertions.assertEquals(expected,outContent.toString());
    }

    /**
     * Test if app can handle empty phrase
     */
    @Test
    public void testEmptyPhrase(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String example = "";
        lettersCounter.calculateLOGICLetters(example);
        String expected = "Empty phrase";
        Assertions.assertEquals(expected,outContent.toString());
    }

    /**
     * Test if app can handle unique combination and same length words
     */
    @Test
    public void testUniqueCombinationSameLength(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        String example = "plate level";
        lettersCounter.calculateLOGICLetters(example);
        String expected = "{(l), 5} = 1.00 (3/3)\n" +
                "TOTAL Frequency: 0.30 (3/10)";
        Assertions.assertEquals(expected,outContent.toString());
    }
}
