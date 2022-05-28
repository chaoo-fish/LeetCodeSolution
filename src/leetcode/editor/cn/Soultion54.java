//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 👍 1070 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Soultion54 {
    public static void main(String[] args) {
        Solution solution = new Soultion54().new Solution();

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] path = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        List<Integer> res = new ArrayList<>();
        int m, n;
        int[][] matrix;
        boolean[][] visited;

        public List<Integer> spiralOrder(int[][] matrix) {
            this.m = matrix.length;
            this.n = matrix[0].length;
            this.matrix = matrix;
            visited = new boolean[m][n];
            bfs(0, 0, 0);
            return res;
        }

        private void bfs(int x, int y, int status) {
            // 能进来,说明肯定可以走的
            res.add(matrix[x][y]);
            // 走过的位置不能走
            visited[x][y] = true;
            // 继续延当前状态
            int[] ints = path[status];
            int newX = x + ints[0];
            int newY = y + ints[1];
            if (isOk(newX, newY) && !visited[newX][newY]) {
                bfs(newX, newY, status);
                return;
            }
            for (int i = 0; i < path.length; i++) {
                if (i == status) continue;
                ints = path[i];
                newX = x + ints[0];
                newY = y + ints[1];
                if (isOk(newX, newY) && !visited[newX][newY]) {
                    bfs(newX, newY, i);
                    break;
                }
            }
        }

        private boolean isOk(int x, int y) {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
