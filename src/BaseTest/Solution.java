package BaseTest;

import java.util.*;

/**
 * 通用模板
 */
class Solution {
    public static void main(String[] args) {
        System.out.println("hello");
    }

    public int leastBricks(List<List<Integer>> wall) {
        int n = wall.size();
        HashMap<Integer,Integer>  map = new HashMap<>();
        for (int i = 0, sum = 0; i < n; i++,sum = 0) {
            for(int cur : wall.get(i)) {
                sum += cur;
                // 记录缝隙
                map.put(sum, map.getOrDefault(sum,0)+1);
            }       
            // 移除最后一个,因为最左边的也不算
            map.remove(sum);     
        }
        int ans = n;
        for (int u : map.keySet()) {
            int cnt = map.get(u); 
            ans = Math.min(ans, n - cnt);
        }
        
        return ans;
    }
}