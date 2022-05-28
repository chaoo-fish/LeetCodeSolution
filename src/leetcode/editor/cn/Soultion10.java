//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa", p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa", p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab", p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 20 
// 1 <= p.length <= 30 
// s 只包含从 a-z 的小写字母。 
// p 只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 👍 2912 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion10 {
    public static void main(String[] args) {
        Solution solution = new Soultion10().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean isMatch(String s, String p) {
            boolean[][] table = new boolean[s.length() + 1][p.length() + 1];

            /*
               0 0 A * B A
               0 t f t f f
               A f
               B f
               A f
               A f
             */

            /*
                对数组进行初始化
                table[0][0] = true
                // 对第一行进行初始化
                if(c == '*') table[0][x] = table[0][x - 2]
                // 第一列在数组创建的时候就是false了,已经完成初始化
                table[x][0] = false
             */
            table[0][0] = true;
            for (int col = 1; col < table[0].length; col++) {
                char ch = p.charAt(col - 1);
                if (col > 1) { // 保证 col-2 存在
                    if (ch == '*') {
                        table[0][col] = table[0][col - 2];
                    } else {
                        table[0][col] = false; // 增加代码可读性
                    }
                } else {
                    if (ch == '*') {
                        table[0][col] = true;
                    }
                }
            }

            // 开始一层一层进行填数
            for (int row = 1; row < table.length; row++) {
                char ch1 = s.charAt(row - 1);
                for (int col = 1; col < table[0].length; col++) {
                    char ch2 = p.charAt(col - 1);
                    if (ch1 == ch2 || ch2 == '.') {
                        table[row][col] = table[row - 1][col - 1];
                    } else if (ch2 == '*') {
                        if (col > 1) {
                            if (table[row][col - 2]) {
                                table[row][col] = true;
                            } else {
                                char prev = p.charAt(col - 2);
                                if (prev == ch1 || prev == '.') {
                                    table[row][col] = table[row - 1][col];
                                }
                            }
                        }
                    }
                }
            }


            return table[table.length - 1][table[0].length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
