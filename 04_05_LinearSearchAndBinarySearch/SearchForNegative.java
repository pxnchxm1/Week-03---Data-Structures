import java.util.Arrays;

public class SearchForNegative {
    public static int returnIdx(int[] arr){
        for(int i = 0; i < arr.length; i++){
            if(arr[i] < 0){
                return i;
            }
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] arr = {1, 2,13,3,-4,4,-5,24,-2,5};
        System.out.println("The array is : " + Arrays.toString(arr));
        int idx = returnIdx(arr);
        System.out.println(idx==-1 ? "No negative numbers in the array ! ":" Negative number found at index : "+ idx);
    }
}
