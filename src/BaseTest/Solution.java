package BaseTest;



/**
 * 通用模板
 */
class Solution {
    public static void main(String[] args) {
        String s = "cbbd";
        String s1 = new Solution().longestPalindrome(s);
        System.out.println(s1);

    }

    int[] temp; // 记录回文左右下标
    int[] index;
    int ans = 0;
    int nowLen = 0;

    // 长度是1000
    public  String longestPalindrome(String s) {
        // 第一个不判断

        for (int i = 0; i < s.length(); i++) {
            // 奇数回文
            isPalindrome(i - 1, i + 1, s);
            // 偶数回文,中心
            isPalindrome(i - 1, i, s);
        }

        return s.substring(index[0], index[1] + 1);
    }

    private  void isPalindrome(int l, int r, String s) {
        while (judgeEqual(l, r, s) && s.charAt(l) == s.charAt(r)) {
            l--;
            r++;
        }
        temp = new int[]{l + 1, r - 1};
        nowLen = temp[1] - temp[0] + 1;
        if (nowLen > ans) {
            index = new int[]{temp[0], temp[1]};
            ans = nowLen;
        }
    }

    private  boolean judgeEqual(int l, int r, String s) {
        if (l < 0 || r >= s.length()) {
            return false;
        }
        return true;
    }
}