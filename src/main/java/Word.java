import java.util.Locale;

public class Word {
    private static int counter_of_LOGIC = 0;
    private int number_of_occurrences;
    private int word_length;
    private char[] founded_chars;

    public Word(int number_of_occurrences, int word_length, char[] founded_chars) {
        this.number_of_occurrences = number_of_occurrences;
        this.word_length = word_length;
        this.founded_chars = founded_chars;
        counter_of_LOGIC += number_of_occurrences;
    }

    public static int getCounter_of_LOGIC() {
        return counter_of_LOGIC;
    }

    public float getFrequency(){
        return (float) number_of_occurrences/counter_of_LOGIC;
    }

    @Override
    public String toString(){
        return String.format(Locale.US,"{(%s), %d} = %.2f (%d/%d)",
                "i",word_length,getFrequency(),number_of_occurrences,counter_of_LOGIC);
    }
}
