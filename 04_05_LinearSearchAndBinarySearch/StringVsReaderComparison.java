import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
public class StringVsReaderComparison {

   

    public static void compareStringBuilders() {
        String word = "hello";
        long iterations = 1000000;

        long t1 = System.nanoTime();
        StringBuilder sb = new StringBuilder();
        for (long i = 0; i < iterations; i++) {
            sb.append(word);
        }
        long t2 = System.nanoTime();
        System.out.println("StringBuilder time: " + (t2 - t1) + " ms");

        long tt1 = System.nanoTime();
        StringBuffer sbf = new StringBuffer();
        for (long i = 0; i < iterations; i++) {
            sbf.append(word);
        }
        long tt2 = System.nanoTime();
        System.out.println("StringBuffer time: " + (tt2 - tt1) + " ms");
    }

    public static void compareFileReaders(String filePath) {
       
        try {
            long start1 = System.nanoTime();
            FileReader fr = new FileReader(filePath);
            int ch;
            StringBuilder content = new StringBuilder();
            while ((ch = fr.read()) != -1) {
                content.append((char) ch);
            }
            fr.close();
            int wordCount1 = countWords(content.toString());
            long end1 = System.nanoTime();
            System.out.println("FileReader word count: " + wordCount1);
            System.out.println("FileReader time: " + (end1 - start1) + " ms");
        } catch (Exception e) {
           System.out.println(e.getMessage());
        }

      
        try {
            long start2 = System.nanoTime();
            InputStreamReader isr = new InputStreamReader(new FileInputStream(filePath));
            int ch;
            StringBuilder content = new StringBuilder();
            while ((ch = isr.read()) != -1) {
                content.append((char) ch);
            }
            isr.close();
            int wordCount2 = countWords(content.toString());
            long end2 = System.nanoTime();
            System.out.println("InputStreamReader word count: " + wordCount2);
            System.out.println("InputStreamReader time: " + (end2 - start2) + " ms");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static int countWords(String text) {
        if (text == null || text.isEmpty()) return 0;
        return text.trim().split(" ").length;
    }

    public static void main(String[] args) {
        System.out.println("---- String Concatenation  ---- ");
        compareStringBuilders();

        System.out.println("\n-- File Reading and Word Count --");
        compareFileReaders( "largetextfile.txt");
    }
}
