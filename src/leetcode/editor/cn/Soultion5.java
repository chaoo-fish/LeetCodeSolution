//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
// Related Topics 字符串 动态规划 👍 4918 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion5 {
    public static void main(String[] args) {
        Solution solution = new Soultion5().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 动态规划

        /**
         * 反转字符串,找最大公共子串
         * @param s
         * @return
         */
        public String longestPalindrome(String s) {
            if (s.equals("")) return "";
            int n = s.length();
            // 初始化数组
            int[][] arr = new int[n][n];
            String reverse = new StringBuilder(s).reverse().toString();
            int maxLen = 0;
            int maxEnd = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (s.charAt(i) == reverse.charAt(j)) {
                        if (i == 0 || j == 0) {
                            arr[i][j] = 1;  // 初始化为1
                        } else {
                            arr[i][j] = arr[i - 1][j - 1] + 1;
                        }
                    }
                    if (arr[i][j] > maxLen) {
                        int reverseIndex = n - j - 1; // 反转字符串在元字符串中位置
                        if (reverseIndex + arr[i][j] - 1 == i) { // 判断下标是否能对应上回文
                            maxLen = arr[i][j];
                            maxEnd = i;
                        }
                    }
                }
            }

            return s.substring(maxEnd - maxLen + 1,maxEnd + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
