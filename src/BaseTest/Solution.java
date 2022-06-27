package BaseTest;

import java.util.*;

/**
 * 通用模板
 */
class Solution {
    public int minCost(int[][] costs) {
        int n = costs.length;
        int a = costs[0][0], b = costs[0][1], c = costs[0][2];
        for (int i = 1; i < n; i++) {
            int aNext = Math.min(b, c) + costs[i][0];
            int bNext = Math.min(a, c) + costs[i][1];
            int cNext = Math.min(a, b) + costs[i][2];
            a = aNext;
            b = bNext;
            c = cNext;
        }

        return Math.min(a, Math.min(b, c));
    }

}