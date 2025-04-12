import java.util.Arrays;

public class RotatedSortedIndex {

    public static int findIndex(int[] nums){
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[mid] > nums[r]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; 
    }
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,8,19,20,21,1,2,3};
        System.out.println("The array is : " + Arrays.toString(arr));
        System.out.println("The index of smallest element is : " + findIndex(arr));
    }
}
