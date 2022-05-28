//编写一个函数来查找字符串数组中的最长公共前缀。 
//
// 如果不存在公共前缀，返回空字符串 ""。 
//
// 
//
// 示例 1： 
//
// 
//输入：strs = ["flower","flow","flight"]
//输出："fl"
// 
//
// 示例 2： 
//
// 
//输入：strs = ["dog","racecar","car"]
//输出：""
//解释：输入不存在公共前缀。 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 200 
// 0 <= strs[i].length <= 200 
// strs[i] 仅由小写英文字母组成 
// 
// Related Topics 字符串 👍 2145 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion14 {
    public static void main(String[] args) {
        Solution solution = new Soultion14().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestCommonPrefix(String[] strs) {
            String preNum = strs[0];
            for (int i = 1; i < strs.length; i++) {
                StringBuilder sb = new StringBuilder();
                int j = 0;
                while (sb.length() < Math.min(preNum.length(), strs[i].length())) {
                    if (preNum.charAt(j) == strs[i].charAt(j)) {
                        ++j;
                        sb.append(preNum.charAt(j));
                    } else {
                        break;
                    }
                }
                preNum = sb.toString();
                if (preNum.length() == 0) {
                    return "";
                }
            }
            return preNum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
