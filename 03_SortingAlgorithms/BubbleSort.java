import java.util.Arrays;
class BubbleSort{
    public static void bubbleSort(int[] arr){
        for(int i= 0;i<arr.length;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
    public static void main(String[] args) {
        int[] marks = {35,98,45,39,78,85,67,89,56,64,39,90,91};
        System.out.println("before sorting :  "+ Arrays.toString(marks));
        bubbleSort(marks);
        System.out.println("sorted mark array is : "+ Arrays.toString(marks));
    }
}