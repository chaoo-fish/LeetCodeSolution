package 周赛;

import java.util.Arrays;

class Solution1 {
    public static void main(String[] args) {
    }

    public int fillCups(int[] amount) {
        Arrays.sort(amount);
        // 一直用少的去消耗多的
        int ans = 0;
        while (amount[2] != 0) {
            if (amount[1] == 0 && amount[0] == 0) return ans += amount[2];
            amount[2]--;
            amount[1]--;
            ans++;
            Arrays.sort(amount);
        }
        return ans;

    }
}