import java.util.ArrayList;
class Stack<T>{
    
    ArrayList<T> stack;
    public Stack(){
        stack = new ArrayList<T>();
    }
    public void push(T element){
        stack.add(element);
    }
    public T pop(){
     T item = stack.get(stack.size()-1);
     stack.remove(stack.size()-1);
     return item;
    }
    public T peek(){
        return stack.get(stack.size()-1);
    }
    public boolean isEmpty(){
        return stack.size()==0;
    }
    public static void main(String[] args){
        Stack<String> s = new Stack<String>();
        s.push("hello");
        s.push("hi");
        s.push("hellohiworld");
        System.out.println(s.peek());
        s.pop();
       
        while(!s.isEmpty()){
           System.out.println(s.pop());
        }
    }
}
