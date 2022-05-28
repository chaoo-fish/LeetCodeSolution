//给定一个可能含有重复元素的整数数组，要求随机输出给定的数字的索引。 您可以假设给定的数字一定存在于数组中。 
//
// 注意： 
//数组大小可能非常大。 使用太多额外空间的解决方案将不会通过测试。 
//
// 示例: 
//
// 
//int[] nums = new int[] {1,2,3,3,3};
//Solution solution = new Solution(nums);
//
//// pick(3) 应该返回索引 2,3 或者 4。每个索引的返回概率应该相等。
//solution.pick(3);
//
//// pick(1) 应该返回 0。因为只有nums[0]等于1。
//solution.pick(1);
// 
// Related Topics 水塘抽样 哈希表 数学 随机化 👍 148 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.*;

public class Soultion398 {
    public static void main(String[] args) {
    }

    class Solution {

        int[] nums;

        public Solution(int[] nums) {
            this.nums = nums;
        }

        /**
         * 个人总结:
         *      其实蓄水池问题,就是一个替换关系,当只有一个数时我们会直接选择这个数,当增加到两个数,我们让第二个数
         *      替换第一个数是1/2,依次类推,要保证是每次替换的概率相同
         */
        public int pick(int target) {
           int ans = 0; // 返回值
           int cnt = 0; // 当前有几个数
            Random random = new Random();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] == target) {
                    cnt++;
                    if (random.nextInt(cnt) == 0) {
                        ans = i; // 发生替换
                    }
                }
            }
           return ans;
        }
    }

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
