import java.io.BufferedReader;
import java.io.FileReader;

public class FileReaderProblemTwo{
    public static void main(String[] args) {
        try {
            FileReader file = new FileReader("textfile.txt");
            BufferedReader bf = new BufferedReader(file);
            int count = 0;
            String word = "leo";
            String line;
            while ((line = bf.readLine()) != null) {
                String[] words = line.split(" ");
                for(String w : words){
                    if(w.equals(word)){
                        count++;
                    }
                }
            }
            System.out.println(" The word " + word + " appears " + count + " times in the file.");
            bf.close();
            file.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
