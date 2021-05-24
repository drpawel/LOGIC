import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Locale;

public class LettersCounter {
    private final char[] logic_chars = {'l','o','g','i','c'};
    private ArrayList<Word> wordArrayList = new ArrayList<>();

    public void calculateLOGICLetters(String phrase){
        String[] words = phrase.split(" ");
        words = Arrays.stream(words).map(String::toLowerCase)
                .map(x->x.replaceAll("[^a-zA-Z0-9]",""))
                .toArray(String[]::new);
        int number_of_chars = Arrays.stream(words).mapToInt(String::length).sum();
        for (int i = 0; i < words.length; i++) {
            wordArrayList.add(countOccurrences(words[i]));
        }
        print(number_of_chars);
    }

    private Word countOccurrences(String text){
        int text_length = text.length();
        //TODO count occurrences
        return new Word(5,text_length,logic_chars);
    }

    private void print(int number){
        wordArrayList.stream().sorted(Comparator.comparing(x -> x.getFrequency()))
                .forEach(System.out::println);
        System.out.print(String.format(Locale.US,"TOTAL Frequency: %.2f (%d/%d)",0.63,Word.getCounter_of_LOGIC(),number));
    }
}
