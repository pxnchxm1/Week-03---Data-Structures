public class ReverseString{
    public static String reverseString(String s){
        StringBuilder sb = new StringBuilder(s);
        return sb.reverse().toString();
    }
   public static void main(String[] args) {
    String str = "This is java programming";
    String reversed = reverseString(str);
    System.out.println("Reversed String: " + reversed);
   }

}