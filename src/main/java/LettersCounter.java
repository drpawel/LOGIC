import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class LettersCounter {
    private final char[] logic_chars;
    private ArrayList<Word> wordArrayList;

    public LettersCounter(char[] logic_chars) {
        this.logic_chars = logic_chars;
    }

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

    private int numberOfCharInWord(String text, char ch){
        return (int) text.chars().filter(x -> x == ch).count();
    }

    private void addOccurrences(Word word){
        for (Word w: wordArrayList) {
            if(w.equals(word)){
                w.addNumber_of_occurrences(word.getNumber_of_occurrences());
            }
        }
    }

    private float calculateFrequency(int number){
        return (float) Word.getCounter_of_LOGIC()/number;
    }

    private void print(int number){
        wordArrayList.stream().sorted(Comparator.comparing(Word::getFrequency).thenComparing(Word::getWord_length).thenComparing(Word::getCharList))
                .forEach(System.out::print);
        System.out.printf(Locale.US,"TOTAL Frequency: %.2f (%d/%d)",
                calculateFrequency(number),Word.getCounter_of_LOGIC(),number);
    }
}
