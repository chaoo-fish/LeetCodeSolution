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
        public String longestPalindrome(String s) {
            int len = s.length();
            if (len < 2) return s;

            int maxLen = 0;
            // 数组第一位记录起始位置，第二位记录长度
            int[] res = new int[2];
            for (int i = 0; i < s.length() - 1; i++) {
                int[] odd = centerSpread(s, i, i); // 奇数情况
                int[] even = centerSpread(s, i, i + 1); // 偶数情况
                int[] max = odd[1] > even[1] ? odd : even;
                if (max[1] > maxLen) {
                    res = max;
                    maxLen = max[1];
                }
            }
            return s.substring(res[0], res[0] + res[1]);
        }

        // 判读回文
        private int[] centerSpread(String s, int left, int right) {
            int len = s.length();
            while (left >= 0 && right <= len) {
                if (s.charAt(left) == s.charAt(right)) {
                    left--;
                    right--;
                } else {
                    break;
                }
            }
            return new int[]{left + 1, right - left - 1};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
