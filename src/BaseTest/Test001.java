package BaseTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test001 {
    public static void main(String[] args) {
        Test001 test001 = new Test001();
        int[] nums = new int[]{1,1,3,3};
        int[] ints = test001.twoSum(nums, 4);
        System.out.println(Arrays.toString(ints));
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                System.out.println(map.toString());
                return new int[]{map.get(target - nums[i]),i};
            }
            map.put(nums[i],i);
        }
        return new int[0];
    }
}
