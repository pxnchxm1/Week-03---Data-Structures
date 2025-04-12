import java.util.Arrays;
public class MergeSort {
    public static void conquer(int[] arr,int l,int mid,int r){
        int lidx = l;
        int ridx = mid+1;
        int i=0;
        int[] ans = new int[r-l+1];
        while(lidx<=mid && ridx<=r){
            if(arr[lidx]<arr[ridx])
                ans[i++] = arr[lidx++];
            else
                ans[i++] = arr[ridx++];
        }
        while(lidx<=mid)
        ans[i++] = arr[lidx++];
        while(ridx<=r)
        ans[i++] = arr[ridx++];
        for(i=0;i<ans.length;i++)
            arr[l+i] = ans[i];
    }
    public static void mergeSort(int[] arr,int si,int ei){
        if(si>=ei){
            return;
        }
        int mid = si + (ei - si) / 2;
        mergeSort(arr, si, mid);
        mergeSort(arr, mid+1, ei);
        conquer(arr, si, mid, ei);
       

    }
    public static void main(String[] args) {
        int[] prices = {5, 3, 8, 4, 2};
        System.out.println(" before sorting : " + Arrays.toString(prices));
        mergeSort(prices, 0, prices.length - 1);
        System.out.println(" after sorting : " + Arrays.toString(prices));
    }
}
