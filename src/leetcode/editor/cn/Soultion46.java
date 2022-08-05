//给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,3]
//输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = [0,1]
//输出：[[0,1],[1,0]]
// 
//
// 示例 3： 
//
// 
//输入：nums = [1]
//输出：[[1]]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 6 
// -10 <= nums[i] <= 10 
// nums 中的所有整数 互不相同 
// 
// Related Topics 数组 回溯 👍 1859 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.*;

public class Soultion46 {
    public static void main(String[] args) {
        Solution solution = new Soultion46().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        // 用来接收返回的数据
        List<List<Integer>> res = new LinkedList<>();

        // 判断当前位置有没有走过
        boolean[] flag;

        public List<List<Integer>> permute(int[] nums) {
            List<Integer> track = new LinkedList<>();
            flag = new boolean[nums.length];
            backtrack(0, nums, track);
            return res;
        }

        void backtrack(int first, int[] nums, List<Integer> track) {
            // 终止条件
            if (first == nums.length) {
                res.add(new LinkedList<>(track));
                return;
            }
            for (int i = 0; i < nums.length; i++) {
                if (!flag[i]) {
                    // 添加数字
                    flag[i] = true;
                    track.add(nums[i]);
                    backtrack(first + 1, nums, track);
                    // 回溯
                    track.remove(track.size() - 1);
                    flag[i] = false;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
