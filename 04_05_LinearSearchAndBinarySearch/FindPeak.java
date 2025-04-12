import java.util.Arrays;

public class FindPeak {

    public static int findPeak(int[] arr){ 
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if((arr[mid]>arr[mid+1]) && (arr[mid]>arr[mid-1])){
                return arr[mid];
            }else if(arr[mid]<arr[mid-1]){
                r = mid;
            }else if(arr[mid]<arr[mid+1]){
                l = mid+1;
            }
        }
        return arr[l];
    }
    public static void  main(String []  args)  {  
        int[] arr = {3,4,5,3,2,3,5,2,9,4,1,8,2};
        System.out.println("The array is : " + Arrays.toString(arr));
        int ans = findPeak(arr);
        System.out.println("One of the peak element is : " + findPeak(arr) );
    }
}
