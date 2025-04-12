import java.util.HashMap;
public class LongestConsecutiveSequence {
    public static int longestSequence(int[] nums){
        HashMap<Integer,Integer> map = new HashMap<>();
        int start = 0;
        int count=0;
        for(int i=1;i<nums.length;i++){
            if(nums[i]-nums[i-1] != 1){
                map.put(start,count);
                start = i;
                count = 0;
            }
            count++;

        }
        map.put(start,count);
        int max = 0;
        for(int j : map.keySet()){
            max = Math.max(max,map.get(j));
        }
            
        
        return max==0 ? -1 : max;
    }
    public static void main(String[] args) {
        int[] nums ={3,5,4,1,2,4,5,6,8,1,2,3,4,5,6,7,8};
        longestSequence(nums);
        System.out.println(" Longest Consecutive Sequence is "+longestSequence(nums));
    }
}
