//给你一个 n x n 的二进制矩阵 grid 中，返回矩阵中最短 畅通路径 的长度。如果不存在这样的路径，返回 -1 。 
//
// 二进制矩阵中的 畅通路径 是一条从 左上角 单元格（即，(0, 0)）到 右下角 单元格（即，(n - 1, n - 1)）的路径，该路径同时满足下述要求
//： 
//
// 
// 路径途经的所有单元格都的值都是 0 。 
// 路径中所有相邻的单元格应当在 8 个方向之一 上连通（即，相邻两单元之间彼此不同且共享一条边或者一个角）。 
// 
//
// 畅通路径的长度 是该路径途经的单元格总数。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [[0,1],[1,0]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：grid = [[0,0,0],[1,1,0],[1,1,0]]
//输出：4
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,0,0],[1,1,0],[1,1,0]]
//输出：-1
// 
//
// 
//
// 提示： 
//
// 
// n == grid.length 
// n == grid[i].length 
// 1 <= n <= 100 
// grid[i][j] 为 0 或 1 
// 
// Related Topics 广度优先搜索 数组 矩阵 👍 174 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.Queue;

public class Soultion1091 {
    public static void main(String[] args) {
        Solution solution = new Soultion1091().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int shortestPathBinaryMatrix(int[][] grid) {
            if (grid == null || grid.length == 0 || grid[0].length == 0) {
                return -1;
            }
            // 起点阻塞
            if (grid[0][0] == 1) {
                return -1;
            }
            // 定义8个方向
            int[][] dir = {{1, -1}, {1, 0}, {1, 1}, {0, -1}, {0, 1}, {-1, -1}, {-1, 0}, {-1, 1}};
            int m = grid[0].length;
            int n = grid.length;

            //
            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{0, 0}); // 加入起点
            grid[0][0] = 1;
            int path = 1; // 层数 即 步数

            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size-- > 0) {
                    int[] cur = queue.poll();
                    int x = cur[0];
                    int y = cur[1];

                    // 能放进队列里的都是为0可以走的
                    // 走到终点 返回
                    if (x == m - 1 && y == n - 1) {
                        return path;
                    }

                    // 开始八个方向的判断
                    for (int[] d : dir) {
                        int x1 = x + d[0];
                        int y1 = y + d[1];
                        // 如果该方向下一个是1 直接跳到下一个方向的判断
                        if (x1 < 0 || x1 >= m || y1 < 0 || y1 >= n || grid[x1][y1] == 1) {
                            continue;
                        }
                        // 把在数组范围内 并且为0不阻塞的放入队列中
                        queue.add(new int[]{x1, y1});
                        grid[x1][y1] = 1; // 标记已经走过
                    }
                }
                path++; // 遍历完一层 这时候要 ++
            }
            return -1; // 走不通返回 -1
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
