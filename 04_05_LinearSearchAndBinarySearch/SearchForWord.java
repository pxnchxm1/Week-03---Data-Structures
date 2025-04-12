import java.util.Arrays;
public class SearchForWord {
    public static String returnSentence(String[] arr,String word){
        for( String s : arr){
            for(String w : s.trim().split(" ")){
                if(w.equals(word)){
                    return s;
                }
            }
        }
        
        return "Not Found";
    }
    public static void main(String[] args) {
        String[] para = {
            "This is basically a learning step for java programming .",
            " This is an apple .",
            "An apple a day keeps the doctor away .",
            "I cant build any more sentence. hehe !"
        };
        System.out.println("The article is is : " + Arrays.toString(para));
        System.out.println(returnSentence(para,"doctor"));
    }
}
