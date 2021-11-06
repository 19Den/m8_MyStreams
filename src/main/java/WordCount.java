import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class WordCount {
    public void countWords() throws IOException {
        File file = new File("wordsEx3.txt");
        file.exists();

        BufferedReader br = new BufferedReader(new FileReader("wordsEx3.txt"));
        String string;
        String sum = "";
        while ((br.readLine()) != null) {
            string = br.readLine();
            if (string != null) {
                if (!string.isBlank())
                    sum = sum + " " + string.trim();
            }
        }
        String[] words = sum.trim().split("\\s+");
        HashMap<String, Integer> wordToCount = new HashMap<>();
        for (String word : words) {
            if (!wordToCount.containsKey(word)) {
                wordToCount.put(word, 0);
            }
            wordToCount.put(word, wordToCount.get(word) + 1);
        }
        wordToCount.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                .forEach(System.out::println);
    }
}
