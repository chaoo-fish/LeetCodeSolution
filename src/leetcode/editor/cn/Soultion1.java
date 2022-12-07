//给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那 两个 整数，并返回它们的数组下标。 
//
// 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。 
//
// 你可以按任意顺序返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [2,7,11,15], target = 9
//输出：[0,1]
//解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,2,4], target = 6
//输出：[1,2]
// 
//
// 示例 3： 
//
// 
//输入：nums = [3,3], target = 6
//输出：[0,1]
// 
//
// 
//
// 提示： 
//
// 
// 2 <= nums.length <= 10⁴ 
// -10⁹ <= nums[i] <= 10⁹ 
// -10⁹ <= target <= 10⁹ 
// 只会存在一个有效答案 
// 
//
// 进阶：你可以想出一个时间复杂度小于 O(n²) 的算法吗？ 
// Related Topics 数组 哈希表 👍 13785 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.*;

public class Soultion1 {
    public static void main(String[] args) {
        Solution solution = new Soultion1().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {


        public boolean wordBreak(String s, List<String> wordDict) {
            Deque<Integer> deq = new ArrayDeque<>();
            deq.getLast();
            /**
             * 应当仔细思考
             * 使用 dp 并没有去做无用操作
             */
            Set<String> set = new HashSet<>();
            for (String ss : wordDict) {
                set.add(ss);
            }
            boolean[] dp = new boolean[s.length() + +1];
            // 空串为 true
            dp[0] = true;
            for (int i = 1; i <= s.length(); i++) { // 裁剪字符串是左闭右开
                for (int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) { // 每次截取的是 j - i  也就是从后面截取的
                        dp[i] = true;
                        break;
                    }
                }
            }


            return dp[s.length()];
        }

        int len = 0;
        int[] nums;

        public int[] twoSum(int[] nums, int target) {
            Arrays.sort(nums);
            len = nums.length;
            this.nums = nums;
            for (int i = 0; i < nums.length; i++) {
                int index = binarySearch(target - nums[i]);
                // 二分查找
                if ((index = index == i ? -1 : 1) != -1) {
                    return new int[]{i, index};
                }
            }
            return new int[0];
        }

        private int binarySearch(int target) {
            // 查找右边界,向左靠
            int l = 0, r = len - 1, mid = 0;
            while (l < r) {
                mid = l + (r - l + 1 >> 1);
                if (nums[mid] <= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            return l;
        }
//leetcode submit region end(Prohibit modification and deletion)

    }
}
