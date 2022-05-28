package 周赛;

import java.util.*;

class Solution2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        Map<Integer, Integer> map = new HashMap<>();
        System.out.println(map.get(1));
    }

    public int minimumCardPickup(int[] cards) {
        int res = Integer.MAX_VALUE;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < cards.length; i++) {
            if (map.get(cards[i]) == null) {
                map.put(cards[i], i);
            } else {
                res = Math.min(i - map.get(cards[i]) + 1, res);
                map.put(cards[i], i);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }

}