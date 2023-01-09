package leetcode.editor.cn;

/**
 * 通用模板
 */

public class Soultion {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) min = prices[i]; // 更新最小值
            res = Math.max(prices[i] - min, res);
        }
        return res;
    }
}


