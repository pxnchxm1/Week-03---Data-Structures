import java.util.Arrays;
import java.util.Stack;
public class StockSpan {
    public static int[] calculateSpan(int[] p){
        int[] ans = new int[p.length];
        Stack<Integer> s = new Stack<>();
        for(int i=0;i<p.length;i++){
            while(!s.isEmpty() && p[s.peek()] <= p[i]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i] = i + 1;
            } else {
                ans[i] = i - s.peek();
            }
            s.push(i);
        }
        return ans;
    } 
    public static void main(String[] args) {
        int[] prices = {100, 80, 60, 70, 60, 75, 85};
        int[] span = calculateSpan(prices);
        System.out.println("Stock prices: " + Arrays.toString(prices));
        System.out.println("Stock span: " + Arrays.toString(span));
    }
}
