import java.util.HashMap;
public class TwoSum {
    public static int[] twoSum(int[] nums,int k){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])){
                return new int[]{map.get(nums[i]),i};
            }else{
                map.put(k-nums[i],i);
            }
        }
        return new int[]{};

    }
    public static void main(String[] args) {
        int[] nums = {3,4,2,5,6};
        int target = 5;
        int[] ans = twoSum(nums, target);
        System.out.println("elements " + nums[ans[0]] + "index(" + ans[0] + ") , " + nums[ans[1]] + "index(" + ans[1] + ") adds up to the number "+   target);
    }
}
