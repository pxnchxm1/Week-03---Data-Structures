import java.util.Arrays;
public class ConcatenateStrings {
    public static String concatenate(String[] s){
       StringBuffer ans = new StringBuffer();
       for(String str : s){
        ans.append(str+" ");
       }
       return ans.toString().trim();
    }
    public static void main(String[] args) {
        String[] strings = {"This","is","Bridge","Labs","Programming","Bootcamp","."};
        System.out.println("Before concatenating , the string is : "+ Arrays.toString(strings));
        System.out.println(concatenate(strings));
    }
}
