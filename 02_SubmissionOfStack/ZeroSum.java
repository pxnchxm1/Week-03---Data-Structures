
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ZeroSum {
    public static List<int[]> findZeroSumSubarrays(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<int[]> result = new ArrayList<>();
        map.put(0, 0);
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
            if (map.containsKey(sum)) {
                int start = map.get(sum);
                int end = i;
                result.add(Arrays.copyOfRange(arr, start, end + 1));    
            } else {
                map.put(sum, i + 1);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = { 1, 2, -2, -1, 0, 1, -1 };
        List<int[]> result = findZeroSumSubarrays(arr);
        for (int[] subarray : result) {
            System.out.println(Arrays.toString(subarray));
        }
        

    }

}
