//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -10⁴ <= matrix[i][j], target <= 10⁴ 
// 
// Related Topics 数组 二分查找 矩阵 👍 592 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion74 {
    public static void main(String[] args) {
        Solution solution = new Soultion74().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            return searchMatrix(matrix, 0, matrix[0].length * matrix.length, target);
        }

        private boolean searchMatrix(int[][] matrix, int low, int high, int target) {
            if (matrix[0].length * matrix.length - 1 >= target) {

            }
            if (low > high ) {
                return false;
            }
            int x = matrix[0].length; // 一行有几个

            int mid = low + (high - low) / 2;
            int m = mid / x;
            int n = mid % x;
            if (matrix[m][n] == target) {
                return true;
            }
            if (matrix[m][n] > target) {
                return searchMatrix(matrix, low, mid - 1, target);
            } else {
                return searchMatrix(matrix, mid + 1, high, target);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
