package 周赛;

import java.util.*;

class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        solution.appealSum("abbca");
    }

    public long appealSum(String s) {
        long ans = 0L,sumG = 0L;
        int[] pos = new int[26];
        Arrays.fill(pos,-1);
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            sumG += i - pos[c];
            ans += sumG;
            pos[c] = i;
        }
        return ans;
    }
}