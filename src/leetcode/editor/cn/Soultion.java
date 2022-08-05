package leetcode.editor.cn;

import java.util.Arrays;

/**
 * 通用模板
 */
class Solution {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int res = 0;
        int i = 0;
        for (int house : houses) {
            // 只需要找房子右边的热水器就行
            while (i < heaters.length && heaters[i] < house) {
                i++;
            }
            if (i == 0) {
                res = Math.max(res, heaters[i] - house);
            } else if (i == heaters.length) {
                return Math.max(res, houses[houses.length - 1] - heaters[heaters.length - 1]);
            } else {
                res = Math.max(res, Math.min(heaters[i] - house, house - heaters[i - 1]));
            }
        }
        return res;
    }
}
