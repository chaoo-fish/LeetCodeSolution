//给你两个字符串 s1 和 s2 ，写一个函数来判断 s2 是否包含 s1 的排列。如果是，返回 true ；否则，返回 false 。 
//
// 换句话说，s1 的排列之一是 s2 的 子串 。 
//
// 
//
// 示例 1： 
//
// 
//输入：s1 = "ab" s2 = "eidbaooo"
//输出：true
//解释：s2 包含 s1 的排列之一 ("ba").
// 
//
// 示例 2： 
//
// 
//输入：s1= "ab" s2 = "eidboaoo"
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s1.length, s2.length <= 10⁴ 
// s1 和 s2 仅包含小写字母 
// 
// Related Topics 哈希表 双指针 字符串 滑动窗口 👍 578 👎 0

/**
 * @author sanshisi
 */
package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Set;

public class Soultion567 {
    public static void main(String[] args) {
        Solution solution = new Soultion567().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean checkInclusion(String s1, String s2) {
            HashMap<Character, Integer> hm1 = new HashMap<>();
            HashMap<Character, Integer> hm2 = new HashMap<>();
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            for (char c : c1) {
                hm1.put(c, hm1.getOrDefault(c, 0) + 1);
            }

            Set<Character> keySet = hm1.keySet();
            int end = 0;
            for (end = 0; end < s1.length() - 1; end++) {
                hm2.put(c2[end], hm1.getOrDefault(c2[end], 0) + 1);
            }

            boolean flag = false;
            for (int start = 0; end < s2.length(); end++) {
                hm2.put(c2[end],hm2.getOrDefault(c2[end],0) + 1); // 每次end向后移动,添加元素
                flag = true;
                // 判断是否
                for(char key : keySet) {
                    if (hm2.get(key) != hm1.get(key)) {
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    return flag;
                }
                hm2.put(c2[start],hm2.get(c2[start]) - 1); // 删除start位置元素,之后再向后移动
            }
            return flag;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
