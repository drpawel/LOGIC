import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

/**
 * Class representing counter of letters in phrase
 */
public class LettersCounter {
    private final char[] logic_chars;
    private ArrayList<Word> wordArrayList;

    /**
     * LettersCounter constructor
     * @param logic_chars array of chars to be found
     */
    public LettersCounter(char[] logic_chars) {
        this.logic_chars = logic_chars;
    }

    /**
     * Search for char occurrences function
     * @param phrase phrase in which we want find chars
     */
    public void calculateLOGICLetters(String phrase){
        wordArrayList = new ArrayList<>();
        if(phrase.isEmpty()){
            System.out.print("Empty phrase");
            return;
        }

        String[] words = phrase.split(" ");
        words = Arrays.stream(words).map(String::toLowerCase)
                .map(x->x.replaceAll("[^a-zA-Z0-9]",""))
                .toArray(String[]::new);

        for (String word : words) {
            Word tmp_word = countOccurrences(word);
            if(wordArrayList.stream().anyMatch(x-> x.equals(tmp_word))){
                addOccurrences(tmp_word);
            }else{
                wordArrayList.add(tmp_word);
            }
        }

        int number_of_chars = Arrays.stream(words).mapToInt(String::length).sum();
        print(number_of_chars);

        Word.resetCounter_of_LOGIC();
    }

    /**
     * Function counting char occurrences in single word
     * @param text single word
     * @return Word with fields corresponding to the occurrence
     */
    private Word countOccurrences(String text){
        int text_length = text.length();
        int occurrences = 0;
        ArrayList<Character> characters = new ArrayList<>();
        for (char logic_char : logic_chars) {
            int counter = numberOfCharInWord(text, logic_char);
            if (counter > 0) {
                occurrences += counter;
                characters.add(logic_char);
            }
        }
        return new Word(occurrences,text_length,characters);
    }

    /**
     * Function calculating number of occurrences of single char
     * @param text word in which we search
     * @param ch char to be found
     * @return number of occurrences
     */
    private int numberOfCharInWord(String text, char ch){
        return (int) text.chars().filter(x -> x == ch).count();
    }

    /**
     * Function adding occurrences to existing Word
     * @param word word with occurrences to add
     */
    private void addOccurrences(Word word){
        for (Word w: wordArrayList) {
            if(w.equals(word)){
                w.addNumber_of_occurrences(word.getNumber_of_occurrences());
            }
        }
    }

    /**
     * Function calculating total frequency
     * @param number total number of non-special chars in phrase
     * @return total frequency
     */
    private float calculateFrequency(int number){
        return (float) Word.getCounter_of_LOGIC()/number;
    }

    /**
     * Function printing all info about chars occurrence
     * @param number total number of non-special chars in phrase
     */
    private void print(int number){
        wordArrayList.stream().sorted(Comparator.comparing(Word::getFrequency).thenComparing(Word::getWord_length).thenComparing(Word::getCharList))
                .forEach(System.out::print);
        System.out.printf(Locale.US,"TOTAL Frequency: %.2f (%d/%d)",
                calculateFrequency(number),Word.getCounter_of_LOGIC(),number);
    }
}
