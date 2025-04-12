public class FirstAndLastOcc {
    public static int findFirstOcc(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int first = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                first = mid;
                r = mid - 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return first;
    }
    public static int findLastOcc(int[] arr, int target) {
        int l = 0, r = arr.length - 1;
        int last = -1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == target) {
                last = mid;
                l = mid + 1;
            } else if (arr[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        return last;
    }
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,7,7,7,8,9,12,17};
        int target = 7 ;
        System.out.println("first occurence of "+target + " in the array is at index : "+ findFirstOcc(arr, target));
        System.out.println("last occurence of "+target + " in the array is at index : "+ findLastOcc(arr, target));
        
    }
}

