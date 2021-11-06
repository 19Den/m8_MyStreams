import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class PersonData {

    public void personData() throws IOException {
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
                try (FileWriter writer = new FileWriter("user.json")) {
                    gson.toJson(person, writer);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
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
