//国际象棋中的骑士可以按下图所示进行移动： 
//
// . 
//
// 
//这一次，我们将 “骑士” 放在电话拨号盘的任意数字键（如上图所示）上，接下来，骑士将会跳 N-1 步。每一步必须是从一个数字键跳到另一个数字键。 
//
// 每当它落在一个键上（包括骑士的初始位置），都会拨出键所对应的数字，总共按下 N 位数字。 
//
// 你能用这种方式拨出多少个不同的号码？ 
//
// 因为答案可能很大，所以输出答案模 10^9 + 7。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：1
//输出：10
// 
//
// 示例 2： 
//
// 输入：2
//输出：20
// 
//
// 示例 3： 
//
// 输入：3
//输出：46
// 
//
// 
//
// 提示： 
//
// 
// 1 <= N <= 5000 
// 
// Related Topics 动态规划 👍 105 👎 0

/**
 * @author sanshisi
 */
package leetcode.editor.cn;

public class Soultion935 {
    public static void main(String[] args) {
        Solution solution = new Soultion935().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int knightDialer(int n) {
            // 动态规划 题目和1220解法一样
        /*
            在国际象棋中 骑士也就是马 是走2*6矩形对角线
            因此使用动态规划: 假设现在在1的位置,那么前一个状态就是8,6s
            0: 4 6
            1: 8 6
            2: 7 9
            3: 4 8
            4: 3 9 0
            5: 0种
            6: 1 7 0
            7: 2 6
            8: 1 3
            9: 4 2
         */
            int mod = (int) (1e9 + 7);
            long[] dp = new long[10];
            long[] temp = new long[10];

            for (int i = 0; i < 10; i++) {
                dp[i] = 1;
            }

            for (int i = 2; i <= n; i++) {
                temp[0] = (dp[4] + dp[6]) % mod;
                temp[1] = (dp[8] + dp[6]) % mod;
                temp[2] = (dp[7] + dp[9]) % mod;
                temp[3] = (dp[4] + dp[8]) % mod;
                temp[4] = (dp[3] + dp[9] + dp[0]) % mod;
                temp[5] = 0;
                temp[6] = (dp[1] + dp[7] + dp[0]) % mod;
                temp[7] = (dp[2] + dp[6]) % mod;
                temp[8] = (dp[1] + dp[3]) % mod;
                temp[9] = (dp[4] + dp[2]) % mod;
                for (int j = 0; j < 10; j++) {
                    dp[j] = temp[j];
                }
            }
            long res = 0;
            for (int i = 0; i < 10; i++) {
                res = (res + dp[i]) % mod;
            }
            return (int) res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
