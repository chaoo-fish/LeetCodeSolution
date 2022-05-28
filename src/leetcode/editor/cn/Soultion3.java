//给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcabcbb"
//输出: 3 
//解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
// 
//
// 示例 2: 
//
// 
//输入: s = "bbbbb"
//输出: 1
//解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
// 
//
// 示例 3: 
//
// 
//输入: s = "pwwkew"
//输出: 3
//解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
//     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
// 
//
// 示例 4: 
//
// 
//输入: s = ""
//输出: 0
// 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 5 * 10⁴ 
// s 由英文字母、数字、符号和空格组成 
// 
// Related Topics 哈希表 字符串 滑动窗口 👍 6776 👎 0

/**
 * @author sanshisi
 */
package leetcode.editor.cn;

import java.util.HashMap;

public class Soultion3 {
    public static void main(String[] args) {
        Solution solution = new Soultion3().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int lengthOfLongestSubstring(String s) {
            if (s == null || s.length() == 0) {
                return 0;
            }
            HashMap<Character, Integer> map = new HashMap<>();
            char[] c = s.toCharArray();
            int max = 0;
            for (int start = 0,end = 0; end < s.length(); end++) {
                if (map.containsKey(c[end])) {
                    start = Math.max(map.get(c[end]) + 1,start);
                    /*
                     j k a b c d a e f g
                     一直从j-d都没问题
                     接下来更新遇到相同的值a,更新start位置
                     可以理解为将start更新为b所在的位置
                     */
                }
                max = Math.max(max,end - start + 1);// 取最大值
                map.put(c[end],end);
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
