//给定一个未排序的整数数组 nums ， 返回最长递增子序列的个数 。 
//
// 注意 这个数列必须是 严格 递增的。 
//
// 
//
// 示例 1: 
//
// 
//输入: [1,3,5,4,7]
//输出: 2
//解释: 有两个最长递增子序列，分别是 [1, 3, 4, 7] 和[1, 3, 5, 7]。
// 
//
// 示例 2: 
//
// 
//输入: [2,2,2,2,2]
//输出: 5
//解释: 最长递增子序列的长度是1，并且存在5个子序列的长度为1，因此输出5。
// 
//
// 
//
// 提示: 
//
// 
//
// 
// 1 <= nums.length <= 2000 
// -10⁶ <= nums[i] <= 10⁶ 
// 
// Related Topics 树状数组 线段树 数组 动态规划 👍 573 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion673 {
    public static void main(String[] args) {
        Solution solution = new Soultion673().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findNumberOfLIS(int[] nums) {
            int n = nums.length;
            // f 存的是最大值
            // g 存的是最大值的数量
            int[] f = new int[n], g = new int[n];
            int max = 1;
            for (int i = 0; i < n; i++) {
                f[i] = g[i] = 1; // 每个独立的都是1
                for (int j = 0; j < i; j++) {
                    if (nums[j] < nums[i]) { // 只有小于当前数才会去判断
                        if (f[i] < f[j] + 1) {
                            f[i] = f[j] + 1;
                            g[i] = g[j];
                        } else if (f[i] == f[j] + 1) {
                            g[i] += g[j];
                        }
                    }
                }
                max = Math.max(max, f[i]);
            }
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (f[i] == max) ans += g[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)
}
