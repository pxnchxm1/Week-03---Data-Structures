import java.util.Arrays;

public class CountSort{
    public static int getMax(int[] arr){
        int max = arr[0];
        for(int i = 1; i < arr.length; i++){
            max = Math.max(max,arr[i]);
        }
        return max;
    }
    public static void countSort(int[] arr){
        int mx = getMax(arr);
        int[] freqs = new int[mx+1];
        for(int i:arr){
            freqs[i]++;
        }
        int[] output = new int[arr.length];
        int idx=0;
        for(int i = 0; i < freqs.length; i++){
            while(freqs[i]>0){
                output[idx++]=i;
                freqs[i]--;
            }
        }
        for(int i = 0; i < arr.length; i++){
            arr[i] = output[i];
        }
    }
    public static void main(String[] args) {
        int[] ages = {23,54,87,34,65,21,12,7};
        System.out.println("before sorting : "+ Arrays.toString(ages));
        countSort(ages);
        System.out.println("after sorting : "+ Arrays.toString(ages));
    }
}