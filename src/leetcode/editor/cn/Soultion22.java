//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 👍 2467 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Soultion22 {
    public static void main(String[] args) {
        Solution solution = new Soultion22().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            if (n == 0) {
                return res;
            }
            back(n, "", 0, 0);
            return res;
        }

        private void back(int n, String s, int l, int r) {
            if (s.length() == n*2) {
                res.add(s);
                return;
            }
            if (l == n) {
                back(n, s + ")", l, r + 1);
                return;
            }

            if (l == r) {
                back(n, s + "(", l + 1, r);
                return;
            }
            back(n, s + "(", l + 1, r);
            back(n, s + ")", l, r + 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
