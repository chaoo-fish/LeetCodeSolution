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
            // 使用递归
            dfs("", n, n);
            return res;
        }

        private void dfs(String s, int l, int r) {
            // 截止条件
            if (l == 0 && r == 0) {
                res.add(s);
                return;
            }
            // 拼左括号的要求:剩余左括号数大于 0
            if (l > 0) {
                dfs(s + "(", l - 1, r);
            }
            // 拼右括号的要求:剩余右括号数大于左括号数
            if (r > l) {
                dfs(s + ")", l, r - 1);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
