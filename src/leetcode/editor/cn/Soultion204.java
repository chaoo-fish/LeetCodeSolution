//给定整数 n ，返回 所有小于非负整数 n 的质数的数量 。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 10
//输出：4
//解释：小于 10 的质数一共有 4 个, 它们是 2, 3, 5, 7 。
// 
//
// 示例 2： 
//
// 
//输入：n = 0
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：n = 1
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= n <= 5 * 10⁶ 
// 
// Related Topics 数组 数学 枚举 数论 👍 859 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion204 {
    public static void main(String[] args) {
        Solution solution = new Soultion204().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countPrimes(int n) {
            int count = 0;
            int[] signs = new int[n / 32 + 1];
            for (int i = 2; i < n; i++) {
//                if ((signs[i / 32] & (1 << (i % 32))) == 0) {

                if ((signs[i / 32] & (1 << (i & 31))) == 0) {
                    count++;
                    for (int j = i + i; j < n; j += i) {
                        // 登记该数字
                        signs[j / 32] |= 1 << (j & 31);
                    }
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
