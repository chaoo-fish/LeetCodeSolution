//给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。 
//
// 
//
// 示例 1： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCCED"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"SEE"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = 
//"ABCB"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == board.length 
// n = board[i].length 
// 1 <= m, n <= 6 
// 1 <= word.length <= 15 
// board 和 word 仅由大小写英文字母组成 
// 
//
// 
//
// 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？ 
// Related Topics 数组 回溯 矩阵 👍 1226 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion79 {
    public static void main(String[] args) {
        Solution solution = new Soultion79().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
        int rows; // 行
        int cols; // 列
        int len; // word长度
        boolean[][] visited; // 记录是否走过
        char[] charArray;
        char[][] board;

        public boolean exist(char[][] board, String word) {
            rows = board.length;
            if (rows == 0) return false;
            cols = board[0].length;
            len = word.length();

            charArray = word.toCharArray();
            visited = new boolean[rows][cols];
            this.board = board;
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    if (dfs(i, j, 0)) return true;
                }
            }
            return false;
        }

        private boolean dfs(int x, int y, int begin) {
            // 截止条件
            if (begin == len - 1) {
                // 走到最后一步了,前面都匹配上了,只需要看最后一个能不能匹配上就行
                return board[x][y] == charArray[begin];
            }

            if (board[x][y] == charArray[begin]) {
                visited[x][y] = true;
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[0];
                    if (inArea(newX,newY) && !visited[newX][newY]){
                        if (dfs(newX,newY,begin + 1)) return true;
                    }
                }
                // 回溯
                visited[x][y] = false;
            }
            return false;
        }

        private boolean inArea(int x, int y) {
            return x >= 0 && x < rows && y >= 0 && y < cols;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
