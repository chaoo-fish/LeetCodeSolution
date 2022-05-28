//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。 请你统计并返回 grid 中 负数 的数目。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
// Related Topics 数组 二分查找 矩阵 👍 92 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion1351 {
    public static void main(String[] args) {
        Solution solution = new Soultion1351().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNegatives(int[][] grid) {
            int x = grid.length;
            int y = grid[0].length;
            int res = 0;
            for (int i = 0; i < x; i++) {
                // 先二分找到每一行第一个负数
                // firstNegativeIndex == fni
                int fni = binarySearch(grid[i]);
                if (fni == y || fni == -1) {
                    continue;
                }

                // 第一个负数的位置,代表了之后及之下全是负数
                // 这个就是一个长方形范围
                res += (y - fni) * (x - i);
                // 收缩y范围
                y = fni;
            }

            return res;
        }

        private int binarySearch(int[] nums) {
            int l = 0;
            int r = nums.length - 1;
            while (l < r) {
                int mid = (l + r) >> 1;
                if (nums[mid] <= -1) {
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }
            return nums[l] <= -1 ? l : -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
