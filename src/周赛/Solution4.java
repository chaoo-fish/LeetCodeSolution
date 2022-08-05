package 周赛;

import java.util.HashMap;
import java.util.Map;

class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
    }

    public int minOperations(int[] nums, int[] numsDivide) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }

        return 0;
    }

}