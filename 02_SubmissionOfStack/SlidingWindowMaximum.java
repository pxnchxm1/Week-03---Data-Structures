
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
public class SlidingWindowMaximum {
    public static Deque<Integer> maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        Deque<Integer> res = new ArrayDeque<>();
        for(int i=0;i<k;i++){
            while(dq.size()>0 && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
        }
        res.addLast(nums[dq.peekFirst()]);
        for(int i = k ;i<nums.length;i++){
            while(dq.size()>0 && dq.peekFirst() <= (i-k)){
                dq.pollFirst();
            }
            while(dq.size()>0 && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }
            dq.addLast(i);
            res.addLast(nums[dq.peekFirst()]);
        }
        return res;
        
    }
    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        Deque<Integer> result = maxSlidingWindow(nums, k);
        System.out.println("Input array: " + Arrays.toString(nums));
        System.out.println("Sliding window size: " + k);
        System.out.println("Maximums in each sliding window: " + result);
    }
}
