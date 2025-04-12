import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.InputStreamReader;

public class ConsoleToFile {
    public static void main(String[] args) {
        try{
            InputStreamReader ip = new InputStreamReader(System.in);
            BufferedReader bf = new BufferedReader(ip);
            FileWriter writer = new FileWriter("written.txt");

            System.out.println("Enter text (type 'exit' to finish):");
            String line; 
            while ((line = bf.readLine()) != null) {
                if (line.equalsIgnoreCase("exit")) {
                    break;
                }
                writer.write(line + System.lineSeparator());
            }

            writer.close();
            bf.close();
            ip.close();

            System.out.println("User input saved to written.txt");
        } catch(Exception e){
            System.out.println("Error: " + e.getMessage());
        }
    }

}
