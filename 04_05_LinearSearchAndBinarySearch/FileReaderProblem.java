import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderProblem {
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("textfile.txt");
            BufferedReader bf = new BufferedReader(file);
            String line;
            while ((line = bf.readLine()) != null) {
                System.out.println(line);
            }

            bf.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
