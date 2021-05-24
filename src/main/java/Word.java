import java.util.ArrayList;
import java.util.Locale;

public class Word {
    private static int counter_of_LOGIC = 0;
    private int number_of_occurrences;
    private final int word_length;
    private final ArrayList<Character> founded_chars;

    public Word(int number_of_occurrences, int word_length, ArrayList<Character> founded_chars) {
        this.number_of_occurrences = number_of_occurrences;
        this.word_length = word_length;
        this.founded_chars = founded_chars;
        counter_of_LOGIC += number_of_occurrences;
    }

    public void addNumber_of_occurrences(int number_of_occurrences) {
        this.number_of_occurrences += number_of_occurrences;
    }

    public int getNumber_of_occurrences() {
        return number_of_occurrences;
    }

    public int getWord_length() {
        return word_length;
    }

    public ArrayList<Character> getFounded_chars() {
        return founded_chars;
    }

    public String getCharList(){
        return founded_chars.toString().replace("[","").replace("]","");
    }

    public float getFrequency(){
        return (float) number_of_occurrences/counter_of_LOGIC;
    }

    public static int getCounter_of_LOGIC() {
        return counter_of_LOGIC;
    }

    public static void resetCounter_of_LOGIC() {
        Word.counter_of_LOGIC = 0;
    }

    public boolean equals(Word word){
        return word.getWord_length() == word_length && word.getFounded_chars().equals(founded_chars);
    }

    @Override
    public String toString(){
        return String.format(Locale.US,"{(%s), %d} = %.2f (%d/%d)\n",
                getCharList(),word_length,getFrequency(),number_of_occurrences,counter_of_LOGIC);
    }


}
