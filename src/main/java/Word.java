import java.util.ArrayList;
import java.util.Locale;

/**
 * Class corresponding to presence of letters in word
 */
public class Word {
    private static int counter_of_LOGIC = 0;

    private final int word_length;
    private final ArrayList<Character> found_chars;
    private int number_of_occurrences;

    /**
     * Word constructor
     * @param number_of_occurrences number of found occurrences
     * @param word_length length of the word
     * @param found_chars list of found chars
     */
    public Word(int number_of_occurrences, int word_length, ArrayList<Character> found_chars) {
        this.number_of_occurrences = number_of_occurrences;
        this.word_length = word_length;
        this.found_chars = found_chars;
        counter_of_LOGIC += number_of_occurrences;
    }

    /**
     * Increase occurrences function
     * @param number_of_occurrences number of found occurrences
     */
    public void addNumber_of_occurrences(int number_of_occurrences) {
        this.number_of_occurrences += number_of_occurrences;
    }

    /**
     * Number of occurrences getter
     * @return number of occurrences
     */
    public int getNumber_of_occurrences() {
        return number_of_occurrences;
    }

    /**
     * Length of word getter
     * @return length of word
     */
    public int getWord_length() {
        return word_length;
    }

    /**
     * List of found chars getter
     * @return  List of chars
     */
    public ArrayList<Character> getFound_chars() {
        return found_chars;
    }

    /**
     * Function creating String representation of char list
     * @return String of char list
     */
    public String getCharList(){
        return found_chars.toString().replace("[","").replace("]","");
    }

    /**
     * Calculating frequency function
     * @return frequency of occurrence
     */
    public float getFrequency(){
        return (float) number_of_occurrences/counter_of_LOGIC;
    }

    /**
     * Counter of all occurrences getter
     * @return number of all occurrences
     */
    public static int getCounter_of_LOGIC() {
        return counter_of_LOGIC;
    }

    /**
     * Reset number of all occurrences function
     */
    public static void resetCounter_of_LOGIC() {
        Word.counter_of_LOGIC = 0;
    }

    /**
     * Function comparing two words
     * @param word word to compare
     * @return if word is equal to this
     */
    public boolean equals(Word word){
        return word.getWord_length() == word_length && word.getFound_chars().equals(found_chars);
    }

    /**
     * To String function in required style
     * @return String of char list with frequency
     */
    @Override
    public String toString(){
        return String.format(Locale.US,"{(%s), %d} = %.2f (%d/%d)\n",
                getCharList(),word_length,getFrequency(),number_of_occurrences,counter_of_LOGIC);
    }


}
