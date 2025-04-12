import java.util.ArrayDeque;
import java.util.Deque;

public class CircularTour{
    public static int calcIndex(int[] p ,int[] d){
        Deque<Integer> dq = new ArrayDeque<>();
        int startIndex = 0;
        int fuel = 0;
        int idx = 0;
        while(dq.size()<p.length){
            fuel += (p[idx]-d[idx] );
            dq.offerLast(idx);
            while(fuel<0 && dq.size()>0){
                int j = dq.pollFirst();
                fuel -= (p[j]-d[j]);
                startIndex++;
                if(startIndex >= p.length){
                    return -1;
                }
            }
            idx = (idx+1) % p.length;
        }
        
        return dq.isEmpty() ? -1 : startIndex;
    }
    public static void main(String[] args){
        int[] petrol = {4,6,7,4};
        int[] distance = {6,5,3,5};
        int ans = calcIndex(petrol,distance);
        System.out.println("starting index should be : "+ ans);
    }
}