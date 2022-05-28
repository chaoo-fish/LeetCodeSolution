//给你一个整数 n ，按字典序返回范围 [1, n] 内所有整数。 
//
// 你必须设计一个时间复杂度为 O(n) 且使用 O(1) 额外空间的算法。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 13
//输出：[1,10,11,12,13,2,3,4,5,6,7,8,9]
// 
//
// 示例 2： 
//
// 
//输入：n = 2
//输出：[1,2]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 5 * 10⁴ 
// 
// Related Topics 深度优先搜索 字典树 👍 337 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

public class Soultion386 {
    public static void main(String[] args) {
        Solution solution = new Soultion386().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        /*
            在解题前需要去了解什么是字典数
            只是将存单词变成了存数字
         */

        List<Integer> res = new ArrayList<>();

        public List<Integer> lexicalOrder(int n) {
            // 使用dfs
            for (int i = 1; i <= 9; i++) {
                dfs(i, n);
            }
            return res;
        }

        private void dfs(int cur, int limit) {
            // 截止条件,或许应该叫剪枝
            if (cur > limit) {
                return;
            }
            res.add(cur);
            for (int j = 0; j < 10; j++) {
                dfs(cur * 10 + j, limit);
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
