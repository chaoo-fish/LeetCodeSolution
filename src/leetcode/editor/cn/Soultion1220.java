//给你一个整数 n，请你帮忙统计一下我们可以按下述规则形成多少个长度为 n 的字符串： 
//
// 
// 字符串中的每个字符都应当是小写元音字母（'a', 'e', 'i', 'o', 'u'） 
// 每个元音 'a' 后面都只能跟着 'e' 
// 每个元音 'e' 后面只能跟着 'a' 或者是 'i' 
// 每个元音 'i' 后面 不能 再跟着另一个 'i' 
// 每个元音 'o' 后面只能跟着 'i' 或者是 'u' 
// 每个元音 'u' 后面只能跟着 'a' 
// 
//
// 由于答案可能会很大，所以请你返回 模 10^9 + 7 之后的结果。 
//
// 
//
// 示例 1： 
//
// 输入：n = 1
//输出：5
//解释：所有可能的字符串分别是："a", "e", "i" , "o" 和 "u"。
// 
//
// 示例 2： 
//
// 输入：n = 2
//输出：10
//解释：所有可能的字符串分别是："ae", "ea", "ei", "ia", "ie", "io", "iu", "oi", "ou" 和 "ua"。
// 
//
// 示例 3： 
//
// 输入：n = 5
//输出：68 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 2 * 10^4 
// 
// Related Topics 动态规划 👍 125 👎 0

/**
 * @author sanshisi
 */
package leetcode.editor.cn;

public class Soultion1220 {
    public static void main(String[] args) {
        Solution solution = new Soultion1220().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countVowelPermutation(int n) {
            /*
                可以前接的字母:
                1a:eiu
                2e:ai
                3i:eo
                4o:i
                5u:io

                第n个a 由第 n-1 中的 e i u 的个数相加得到
             */
            int mod = (int) (1e9 + 7); // 模
            long a = 1, e = 1, i = 1, o = 1, u = 1;
            for (int j = 2; j < n; j++) {
                long a1 = (e + i + u) % mod;
                long a2 = (a + i) % mod;
                long a3 = (e + o) % mod;
                long a4 = (i) % mod;
                long a5 = (i + o) % mod;
                a = a1;
                e = a2;
                i = a3;
                o = a4;
                u = a5;
            }
            return (int) ((a + e + i + o + u) % mod);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
