import java.util.HashSet;

public class RemoveDuplicates {
    public static String removeDuplicates(String s){
        HashSet<Character> set = new HashSet<>();
        StringBuilder sb = new StringBuilder();
        for(char c : s.toCharArray()){
            if(!set.contains(c)){
                set.add(c);
                sb.append(c);
            }
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        String str = "This is java programming";
        System.out.println("before removing, the string is : "+ str);
        String pure = removeDuplicates(str);
        System.out.println("String after removing duplicates is : " + pure);
    }
}
