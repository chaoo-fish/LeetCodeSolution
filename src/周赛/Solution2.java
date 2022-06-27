package 周赛;

import java.util.*;

class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
//        int[] nums = new int[]{3,6,1,2,5};
        int[] nums = new int[]{2, 2, 4, 5};
//        int[] nums = new int[]{1,2,3,5,5};
//        int[] nums = new int[]{0,0,0,0};
        int i = s.partitionArray(nums, 0);
        System.out.println(i);
    }

    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        // 1 2 3 5 6
        // 0 1 1 2 1
        // 0 1 2 3 4
        int[] diff = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            diff[i] = nums[i] - nums[i - 1];
        }
        int ans = 1;
        int sum = 0;
        for (int i = 0; i < diff.length; i++) {
            sum += diff[i];
            if (i + 1 != nums.length && nums[i] == nums[i +1]) continue;

            if (i + 1 == nums.length) {
                if (sum > k) ans++;
            }
            if (sum >= k) {
                sum = 0;
                if (i + 1 != diff.length) {
                    diff[i + 1] = 0;
                }
                if (i + 1 != nums.length) ans += 1;
            }
        }


        return ans;
    }
}