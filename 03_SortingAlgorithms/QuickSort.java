import java.util.Arrays;

public class QuickSort{
    public static int partition(int[] arr,int l,int h){
        int pivot = arr[h];
        int idx = l-1;
        for(int j=l;j<h;j++){
            if ((arr[j])<pivot) {
                idx++;
                int temp=arr[idx];
                arr[idx]=arr[j];
                arr[j]=temp;
                
            }
        }
        idx++;
        int t = arr[idx];
        arr[idx] = pivot;
        arr[h] = t;
        return idx;
    }
    public static void quickSort(int[] arr,int l,int h){
        if(l<h){
            int p = partition(arr,l,h);
            quickSort(arr,l,p-1);
            quickSort(arr,p+1,h);
        }
    }
    public static void main(String[] args) {
        int[] prices = { 10, 40, 30, 60, 50, 20 };
        System.out.println(" Before sorting : " + Arrays.toString(prices));
        quickSort(prices,0,prices.length-1);
        System.out.println(" After sorting : " + Arrays.toString(prices));
    }
}