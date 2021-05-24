import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class LettersCounter {
    private final char[] logic_chars = {'l','o','g','i','c'};
    private ArrayList<Word> wordArrayList;

    public void calculateLOGICLetters(String phrase){
        if(phrase.isEmpty()){
            System.out.print("Empty phrase");
            return;
        }

        wordArrayList = new ArrayList<>();
        String[] words = phrase.split(" ");
        words = Arrays.stream(words).map(String::toLowerCase)
                .map(x->x.replaceAll("[^a-zA-Z0-9]",""))
                .toArray(String[]::new);

        for (String word : words) {
            wordArrayList.add(countOccurrences(word));
        }

        int number_of_chars = Arrays.stream(words).mapToInt(String::length).sum();
        print(number_of_chars);

        Word.resetCounter_of_LOGIC();
    }

    private Word countOccurrences(String text){
        int text_length = text.length();
        int occurrences = 0;
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < logic_chars.length; i++) {
            int counter = numberOfCharInWord(text,logic_chars[i]);
            if(counter >0){
                occurrences += counter;
                characters.add(logic_chars[i]);
            }
        }
        return new Word(occurrences,text_length,characters);
    }

    private int numberOfCharInWord(String text, char ch){
        return (int) text.chars().filter(x -> x == ch).count();
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
