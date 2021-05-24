import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.*;

public class CounterTest {
    private LettersCounter lettersCounter = new LettersCounter();

    @Test
    public void testIfPrints(){
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        lettersCounter.foo();
        Assertions.assertEquals("TEST",outContent.toString());
    }
}
