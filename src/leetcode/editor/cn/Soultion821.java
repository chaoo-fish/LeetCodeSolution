//给你一个字符串 s 和一个字符 c ，且 c 是 s 中出现过的字符。 
//
// 返回一个整数数组 answer ，其中 answer.length == s.length 且 answer[i] 是 s 中从下标 i 到离它 最近 的
//字符 c 的 距离 。 
//
// 两个下标 i 和 j 之间的 距离 为 abs(i - j) ，其中 abs 是绝对值函数。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "loveleetcode", c = "e"
//输出：[3,2,1,0,1,0,0,1,2,2,1,0]
//解释：字符 'e' 出现在下标 3、5、6 和 11 处（下标从 0 开始计数）。
//距下标 0 最近的 'e' 出现在下标 3 ，所以距离为 abs(0 - 3) = 3 。
//距下标 1 最近的 'e' 出现在下标 3 ，所以距离为 abs(1 - 3) = 2 。
//对于下标 4 ，出现在下标 3 和下标 5 处的 'e' 都离它最近，但距离是一样的 abs(4 - 3) == abs(4 - 5) = 1 。
//距下标 8 最近的 'e' 出现在下标 6 ，所以距离为 abs(8 - 6) = 2 。
// 
//
// 示例 2： 
//
// 
//输入：s = "aaab", c = "b"
//输出：[3,2,1,0]
// 
//
// 
//提示：
//
// 
// 1 <= s.length <= 10⁴ 
// s[i] 和 c 均为小写英文字母 
// 题目数据保证 c 在 s 中至少出现一次 
// 
// Related Topics 数组 双指针 字符串 👍 227 👎 0

/**
 * @author sanshisi
 */
 
package leetcode.editor.cn;

import java.util.Arrays;

public class Soultion821 {
    public static void main(String[] args) {
        Solution solution = new Soultion821().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[] shortestToChar(String s, char c) {
        /*
            左->右 填好c右边的
            右->左 填好c左边的
         */
        char[] sToArr = s.toCharArray();
        int length = sToArr.length;
        int[] res = new int[length];

        int index = -10010;
        for (int i = 0; i < length; i++) {
            if (sToArr[i] == c) index = i;
            res[i] = i - index;
        }

        index = 10010;
        for (int i = length - 1; i >= 0; i--) {
            if (sToArr[i] == c) index = i;
            // 可以在第二次扫描时就将两次数进行填充比较
            res[i] = Math.min(res[i],index - i);
        }

        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
