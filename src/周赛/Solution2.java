package 周赛;

import java.util.HashMap;
import java.util.PriorityQueue;

class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        int[] nums = new int[]{229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401};
        int i = s.maximumSum(nums);
        System.out.println(i);
    }

    public int maximumSum(int[] nums) {
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            int temp = num;
            int sum = 0;
            while (temp != 0) {
                sum += temp % 10;
                temp /= 10;
            }
            if (map.get(sum) != null) {
                map.get(sum).add(num);
            } else {
                map.put(sum, new PriorityQueue<>((a,b) -> b - a));
                map.get(sum).add(num);
            }
        }

        int ans = Integer.MIN_VALUE;
        for (Integer i : map.keySet()) {
            if (map.get(i).size() < 2) continue;
            int sumTwo = map.get(i).remove() + map.get(i).remove();
            ans = Math.max(ans, sumTwo);
        }

        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}