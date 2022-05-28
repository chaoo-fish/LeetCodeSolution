package BaseTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test2055 {
    public static void main(String[] args) {
//        String s = "**||**|*";
        String s = "**|*****";
//        int[][] qs = {{0,7},{3,7}};
        int[][] qs = {{0,7}};
        int[] ints = platesBetweenCandles(s, qs);
        System.out.println(Arrays.toString(ints));
    }

    static int[] platesBetweenCandles(String s, int[][] qs) {
        char[] cs = s.toCharArray();
        int n = cs.length, m = qs.length;
        int[] ans = new int[m], sum = new int[n + 1];
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (cs[i] == '|') list.add(i); // 存的是蜡烛的角标
            sum[i + 1] = sum[i] + (cs[i] == '*' ? 1 : 0);
        }
        if (list.size() == 0) return ans;
        System.out.println(Arrays.toString(sum));

        for (int i = 0; i < m; i++) { // 遍历每一个区间
            int a = qs[i][0], b = qs[i][1];
            int c = -1, d = -1;
            // 找到 a 右边最近的蜡烛
            int l = 0, r = list.size() - 1;
            while (l < r) {
                int mid = l + r >> 1;

                if (list.get(mid) >= a) r = mid;
                else l = mid + 1;
            }
            if (list.get(r) >= a) c = list.get(r);
            else continue;
            // 找到 b 左边最近的蜡烛
            l = 0;
            r = list.size() - 1;
            while (l < r) {
                int mid = l + r + 1 >> 1;
                if (list.get(mid) <= b) l = mid;
                else r = mid - 1;
            }
            if (list.get(r) <= b) d = list.get(r);
            else continue;
            if (c <= d) ans[i] = sum[d + 1] - sum[c];
        }
        return ans;
    }
}
