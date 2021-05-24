import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class CounterTest {
    private LettersCounter lettersCounter = new LettersCounter();

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
}
