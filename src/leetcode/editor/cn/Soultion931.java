//给你一个 n x n 的 方形 整数数组 matrix ，请你找出并返回通过 matrix 的下降路径 的 最小和 。 
//
// 下降路径 可以从第一行中的任何元素开始，并从每一行中选择一个元素。在下一行选择的元素和当前行所选元素最多相隔一列（即位于正下方或者沿对角线向左或者向右的第
//一个元素）。具体来说，位置 (row, col) 的下一个元素应当是 (row + 1, col - 1)、(row + 1, col) 或者 (row + 1
//, col + 1) 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：matrix = [[2,1,3],[6,5,4],[7,8,9]]
//输出：13
//解释：如图所示，为和最小的两条下降路径
// 
//
// 示例 2： 
//
// 
//
// 
//输入：matrix = [[-19,57],[-40,-5]]
//输出：-59
//解释：如图所示，为和最小的下降路径
// 
//
// 
//
// 提示： 
//
// 
// n == matrix.length == matrix[i].length 
// 1 <= n <= 100 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 动态规划 矩阵 👍 160 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion931 {
    public static void main(String[] args) {
        Solution solution = new Soultion931().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minFallingPathSum(int[][] mat) {
            int n = mat.length;
            int[][] f = new int[n][n];
            for (int i = 0; i < n; i++) {
                f[0][i] = mat[0][i];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    int val = mat[i][j];
                    f[i][j] = f[i - 1][j] + val;
                    if (j - 1 >= 0) f[i][j] = Math.min(f[i][j], f[i - 1][j - 1] + val);
                    if (j + 1 < n) f[i][j] = Math.min(f[i][j], f[i - 1][j + 1] + val);
                }

            }
            int ans = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                ans = Math.min(ans, f[n - 1][i]);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
