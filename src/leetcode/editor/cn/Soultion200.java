//给你一个由 '1'（陆地）和 '0'（水）组成的的二维网格，请你计算网格中岛屿的数量。 
//
// 岛屿总是被水包围，并且每座岛屿只能由水平方向和/或竖直方向上相邻的陆地连接形成。 
//
// 此外，你可以假设该网格的四条边均被水包围。 
//
// 
//
// 示例 1： 
//
// 
//输入：grid = [
//  ["1","1","1","1","0"],
//  ["1","1","0","1","0"],
//  ["1","1","0","0","0"],
//  ["0","0","0","0","0"]
//]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：grid = [
//  ["1","1","0","0","0"],
//  ["1","1","0","0","0"],
//  ["0","0","1","0","0"],
//  ["0","0","0","1","1"]
//]
//输出：3
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 300 
// grid[i][j] 的值为 '0' 或 '1' 
// 
// Related Topics 深度优先搜索 广度优先搜索 并查集 数组 矩阵 👍 1600 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion200 {
    public static void main(String[] args) {
        Solution solution = new Soultion200().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[] di = {0, 0, 1, -1}; // 进行 上下方向遍历
        int[] dj = {1, -1, 0, 0}; // 进行 左右方向遍历

        int ans = 0; // 岛屿的数量

        public int numIslands(char[][] grid) {
            // 1陆  0水
            // 对每个位置进行遍历,走过的地方置为0
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[0].length; j++) {
                    ans += dfs(grid, i, j) == 0 ? 0 : 1;
                }
            }
            return ans;
        }

        public int dfs(char[][] grid, int curI, int curJ) {
            // 如果当前格子不是陆地，直接返回0就行
            if (curI < 0 || curJ < 0 || curI == grid.length || curJ == grid[0].length || grid[curI][curJ] != '1') {
                return 0;
            }
            grid[curI][curJ] = '0'; // 如果是陆地,先置0

            int ans = 1; // 每一个岛屿的ans面积
            for (int index = 0; index < 4; index++) {
                int nextI = curI + di[index], nextJ = curJ + dj[index];
                ans += dfs(grid, nextI, nextJ);
            }
            return ans; // 返回当前岛屿的面积
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
