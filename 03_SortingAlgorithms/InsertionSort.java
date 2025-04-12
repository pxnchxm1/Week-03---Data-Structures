import java.util.Arrays;
public class InsertionSort {

    public static void insertionSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int j = i-1;
            int curr = arr[i];
            while(j>=0 && curr<=arr[j]){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = curr;
        }
    }
    public static void main(String[] args) {
        int[] ids = {101,671,879,100,328,817,111,281};
        System.out.println("Before sorting : "+ Arrays.toString(ids));
        insertionSort(ids);
        System.out.println("After sorting : "+ Arrays.toString(ids));
    }
}
