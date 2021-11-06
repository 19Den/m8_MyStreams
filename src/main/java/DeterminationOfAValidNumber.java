import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class DeterminationOfAValidNumber {

    public void validNumber() {
        File file = new File("fileEx1.txt");
        file.exists();

        try (FileReader reader = new FileReader("fileEx1.txt")) {
            int charReadFromFileReaderInUTF8;
            String str = "";

            while ((charReadFromFileReaderInUTF8 = reader.read()) != -1) {
                if ((charReadFromFileReaderInUTF8 == 13) || (charReadFromFileReaderInUTF8 == 10)) {
                    if (str.matches("(?:\\d{3}-){2}\\d{4}|\\(\\d{3}\\) \\d{3}-?\\d{4}")) {
                        System.out.println(str);
                    }
                    str = "";
                } else {
                    str = str + (char) charReadFromFileReaderInUTF8;
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
