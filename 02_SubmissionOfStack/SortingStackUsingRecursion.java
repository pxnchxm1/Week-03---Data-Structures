import java.util.Scanner;
import java.util.Stack;
public class SortingStackUsingRecursion {
    public static void insertAtCorrectPos(Stack<Integer> s, int n){
        if(s.isEmpty() || s.peek()<=n){
            s.push(n);
        }else{
            int top = s.pop();
            insertAtCorrectPos(s,n);
            s.push(top);
        }
    }
    public static void sortStack(Stack<Integer> stack){
        if(!stack.isEmpty()){
            int top = stack.pop();
            sortStack(stack);
            insertAtCorrectPos(stack,top);
        }
    }
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        System.out.println("enter size of the stack");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("enter element : " + (i+1));
            stack.push(sc.nextInt());
        }
        System.out.println("Original Stack: " + stack);
        sortStack(stack);
        System.out.println("Sorted Stack: " + stack);
        sc.close();
    }
}
