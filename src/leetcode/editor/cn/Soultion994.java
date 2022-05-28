//在给定的 m x n 网格 grid 中，每个单元格可以有以下三个值之一： 
//
// 
// 值 0 代表空单元格； 
// 值 1 代表新鲜橘子； 
// 值 2 代表腐烂的橘子。 
// 
//
// 每分钟，腐烂的橘子 周围 4 个方向上相邻 的新鲜橘子都会腐烂。 
//
// 返回 直到单元格中没有新鲜橘子为止所必须经过的最小分钟数。如果不可能，返回 -1 。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
//输出：4
// 
//
// 示例 2： 
//
// 
//输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
//输出：-1
//解释：左下角的橘子（第 2 行， 第 0 列）永远不会腐烂，因为腐烂只会发生在 4 个正向上。
// 
//
// 示例 3： 
//
// 
//输入：grid = [[0,2]]
//输出：0
//解释：因为 0 分钟时已经没有新鲜橘子了，所以答案就是 0 。
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 10 
// grid[i][j] 仅为 0、1 或 2 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 509 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class Soultion994 {
    public static void main(String[] args) {
        Solution solution = new Soultion994().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 广度优先搜索
        // dirs 是为了对腐烂的橘子进行上下左右的遍历
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        public int orangesRotting(int[][] grid) {
            int m = grid.length, n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>(); // 广度用的是队列

            int count = 0; // 表示新鲜橘子的数量
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if(grid[i][j] == 1) { // 记录新鲜橘子的数量
                        count++;
                    } else if (grid[i][j] == 2) { // 将腐烂的橘子入队
                        queue.add(new int[]{i,j});
                    }
                }
            }

            int round = 0; // round表示腐烂的轮数 -> 分钟数
            while (count >0 && !queue.isEmpty()) {
                round++; // 每次进入都要加一轮
                int nn = queue.size(); // 记录相同时刻腐烂的橘子数
                for (int i = 0; i < nn; i++) {
                    int[] orange = queue.poll();
                    int r = orange[0];
                    int c = orange[1];
                    for (int k = 0; k < 4; k++) {
                        int rk = r + dirs[k][0]; // 更新下一个坐标
                        int ck = c + dirs[k][1];
                        if(rk >= 0 && rk < m && ck >= 0 && ck < n && grid[rk][ck] == 1) { // 是新鲜的才会去执行
                            grid[rk][ck] = 2;
                            count--;
                            queue.add(new int[]{rk,ck});
                        }
                    }
                }
            }
            if (count > 0) {
                return -1; // 因为会有橘子被隔离了,传染不到
            }else {
                return round;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
