import java.util.Arrays;

public class CombineSearch {

    static int firstMissing(int[] nums){
        boolean[] seen = new boolean[nums.length+1];
        for(int i : nums){
            if(i>0 && i<nums.length){
                seen[i] = true;
            }
        }
        for (int i = 1; i <= nums.length; i++) {
            if (!seen[i]) return i;
        }

        return nums.length+ 1;
    }
    public static int target(int[] arr, int target) {
        int l = 0, r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            if (arr[mid] == target) return mid;
            else if (arr[mid] < target) l = mid + 1;
            else r = mid - 1;
        }

        return -1;
    }
    public static void main(String[] args) {
        int[] nums = {3, 4, -1, 1};
        int k = 4;
        System.out.println("The array is : "+ Arrays.toString(nums) + " and the target is : "+ k);
        System.out.println("first missing positive integer is "+ firstMissing(nums));
        int ans = target(nums,k);
        System.out.println(ans==-1? "Not found ": "Target found at index : "+ ans);

    }
}
