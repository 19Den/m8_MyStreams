import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class MyStreams {
    public static void main(String[] args) throws IOException {
//        readFile();
//        personData();
//        countWords();
    }

    //Exercise_3--------------------------------------------------------------------------
    public static void countWords() throws IOException {
        File file = new File("wordsEx3.txt");
        file.exists();

        BufferedReader br = new BufferedReader(new FileReader("wordsEx3.txt"));
        String strings;
        String sum = "";
        while ((br.readLine()) != null) {
            strings = br.readLine();
            if (strings == null || strings.isBlank()) {
//                System.out.println("Строка пустая");
            } else {
                sum = sum + " " + strings.trim();
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
        for (String word : wordToCount.keySet()) {
            System.out.println(word + " " + wordToCount.get(word));
        }
    }

    //Exercise_2--------------------------------------------------------------------------
    public static void personData() throws IOException {
        File file = new File("fileEx2.txt");
        file.exists();

        BufferedReader br = new BufferedReader(new FileReader("fileEx2.txt"));
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        List<Person> person = new ArrayList<>();

        int count = 0;
        while ((br.readLine()) != null) {
            count++;
        }
        String[] strings = new String[count];

        BufferedReader br2 = new BufferedReader(new FileReader("fileEx2.txt"));
        String[] cut;
        for (int i = 0; i < strings.length; i++) {
            strings[i] = br2.readLine();
            if (i > 0) {

                cut = strings[i].split(" ");
                person.add(new Person(cut[0], Integer.parseInt(cut[1])));
                String json = gson.toJson(person);

                try (FileWriter writer = new FileWriter("user.json")) {
                    gson.toJson(person, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    //Exercise_1--------------------------------------------------------------------------------
    public static void readFile() {
        File file = new File("fileEx1.txt");
        file.exists();

        try (FileReader reader = new FileReader("fileEx1.txt")) {
            int c;
            String str = "";

            while ((c = reader.read()) != -1) {
                if ((c == 13) || (c == 10)) {
                    if (str.matches("(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\) \\d{3}-?\\d{4}")) {
                        System.out.println(str);
                    }
                    str = "";
                } else {
                    str = str + (char) c;
                }
            }
            if (str.matches("(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\) \\d{3}-?\\d{4}")) {
                System.out.println(str);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}

class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}