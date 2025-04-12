import java.util.HashSet;
import java.util.TreeSet;

public class CompareSearching {
    public static void main(String[] args) {
        int n = 1000000;
        int[] array = new int[n];
        for (int i = 0; i < n; i++) {
            array[i] = i;
        }
        long startTime = System.nanoTime();
        int target = 500000;
        for (int i = 0; i < n; i++) {
            if (array[i] == target) {
                break;
            }
        }
        long endTime = System.nanoTime();
        System.out.println("Array Search Time: " + (endTime - startTime) + " ns");
        
        
        HashSet<Integer> hs = new HashSet<>();
        for (int i = 0; i < n; i++) {
            hs.add(i);
        }
        startTime = System.nanoTime();
        if (hs.contains(target)) {
            System.out.println("Target found in HashSet");
        }
        endTime = System.nanoTime();
        System.out.println("HashSet Search Time: " + (endTime - startTime) + " ns");

        TreeSet<Integer> ts = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            ts.add(i);
        }
        startTime = System.nanoTime();
        if (ts.contains(target)) {
            System.out.println("Target found in TreeSet");
        }
        endTime = System.nanoTime();
        System.out.println("TreeSet Search Time: " + (endTime - startTime) + " ms " );
        }
    
}
