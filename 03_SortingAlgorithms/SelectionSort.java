import java.util.Arrays;
public class SelectionSort {

    public static void selectionSort(int[] arr){
        for(int i=0;i<arr.length;i++){
            int minIdx = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[i]){
                    minIdx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[minIdx];
            arr[minIdx] = temp;
        }
    }
    public static void main(String[] args) {
        int[] scores = {67,89,75,78,35,90,54,78,29};
        System.out.println("Before sorting, scores are : "+ Arrays.toString(scores));
        selectionSort(scores);
        System.out.println("After sorting, scores are : "+ Arrays.toString(scores));
    }
}
