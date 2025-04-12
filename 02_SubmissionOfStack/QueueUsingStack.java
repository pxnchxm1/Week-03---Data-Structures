import java.util.Scanner;
import java.util.Stack;
// Queue implementation using two stacks
public class QueueUsingStack{
    Stack<Integer> s1 = new Stack<>();
    Stack<Integer> s2 = new Stack<>();
    public  void enqueue(int x){
        s1.push(x);
    }
    public  int dequeue(){
        if(s1.isEmpty()){
            System.out.println("Queue is empty");
            return -1;
        }
        while(!s1.isEmpty()){
            s2.push(s1.pop());
        }
        int x = s2.pop();
        while(!s2.isEmpty()){
            s1.push(s2.pop());
        }
        return x;
    }
    public static void main(String[] args) {
        QueueUsingStack q = new QueueUsingStack();
        System.out.println("enter the number of elements to be added to the queue");
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        for(int i=0;i<n;i++){
            System.out.println("enter the element to be added to the queue");
            int x = sc.nextInt();
            q.enqueue(x);
        }
        System.out.println("enter the number of elements to be removed from the queue");
        int m = sc.nextInt();
        for(int i=0;i<m;i++){
            System.out.println("element removed from the queue is "+q.dequeue());
        }
        sc.close();
        
    }
}