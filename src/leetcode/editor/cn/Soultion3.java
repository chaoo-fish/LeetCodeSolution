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
            if (s == null || s.length() == 0) return 0;
            HashMap<Integer,Integer> map = new HashMap<>(); // 记录字符上一次出现的位置

            int ans = 0; // 记录最大长度
            int start = 0;
            for (int i = 0; i < s.length(); i++) {
                int index = s.charAt(i);
                // 更新开始字符的位置
                /**
                 * 1. 前面没有和这个字符一样的，那么当前开始位置就是start
                 * 2. 有，当前位置更新为start 和 letter[index] + 1 中较大的一个
                 */
                start = Math.max(start,map.getOrDefault(index,0));
                ans = Math.max(ans, i - start + 1);
                map.put(index,i);
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
