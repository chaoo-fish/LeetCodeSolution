//给定一个 24 小时制（小时:分钟 "HH:MM"）的时间列表，找出列表中任意两个时间的最小时间差并以分钟数表示。 
//
// 
//
// 示例 1： 
//
// 
//输入：timePoints = ["23:59","00:00"]
//输出：1
// 
//
// 示例 2： 
//
// 
//输入：timePoints = ["00:00","23:59","00:00"]
//输出：0
// 
//
// 
//
// 提示： 
//
// 
// 2 <= timePoints.length <= 2 * 10⁴ 
// timePoints[i] 格式为 "HH:MM" 
// 
// Related Topics 数组 数学 字符串 排序 👍 154 👎 0

/**
 * @author sanshisi
 */
package leetcode.editor.cn;

import java.util.Comparator;
import java.util.List;

public class Soultion539 {
    public static void main(String[] args) {
        Solution solution = new Soultion539().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findMinDifference(List<String> timePoints) {

            if (timePoints.size() > 1440) {
                return 0;
            }
            // 把小时换算成分钟
            for (int i = 0; i < timePoints.size(); i++) {
                String[] minTwo = timePoints.get(i).split(":");
                int mins = Integer.parseInt(minTwo[0]) * 60 + Integer.parseInt(minTwo[1]);
                timePoints.set(i, mins + "");
            }
            timePoints.sort(new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return Integer.parseInt(o1) - Integer.parseInt(o2);
                }
            });
            int res = 1440;
            for (int i = 1; i < timePoints.size(); i++) {
                int j = i - 1;
                int small = Integer.parseInt(timePoints.get(i)) - Integer.parseInt(timePoints.get(j));
                System.out.println("small" + small);
                // 排序是从小到大
                if (small < res) {
                    res = small;
                }
            }
            int shouWei = 1440 - (Integer.parseInt(timePoints.get(timePoints.size() - 1)) - Integer.parseInt(timePoints.get(0)));

//            int shouWei = 1440 % (Integer.parseInt(timePoints.get(timePoints.size() - 1)) - Integer.parseInt(timePoints.get(0)));
            if (shouWei < res) {
                res = shouWei;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
