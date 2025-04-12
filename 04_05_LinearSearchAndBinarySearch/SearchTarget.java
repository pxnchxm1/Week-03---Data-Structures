
import java.util.Arrays;

public class SearchTarget {
    static boolean elementFound(int[][] arr,int k){
        int l = 0;
        int r = arr.length * arr[0].length - 1;
        while(l<=r){
            int mididx = l + (r - l)/2;
            int row = mididx / arr[0].length;
            int col = mididx % arr[0].length;

            if (arr[row][col] == k) {
                return true;
            } else if (arr[row][col] < k) {
                l = mididx + 1;
            } else {
                r = mididx - 1;
            }

        }
        return false;

    }
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9},{10,11,12}};
        int target = 80 ;
        System.out.println("Matrix is : ");
        for(int[] r : matrix){
            System.out.println(Arrays.toString(r));
        }
        System.out.println("element found ? " + elementFound(matrix,target));
        
    }
}
