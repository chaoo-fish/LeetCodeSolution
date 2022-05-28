//给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。 
//
// candidates 中的每个数字在每个组合中只能使用 一次 。 
//
// 注意：解集不能包含重复的组合。 
//
// 
//
// 示例 1: 
//
// 
//输入: candidates = [10,1,2,7,6,1,5], target = 8,
//输出:
//[
//[1,1,6],
//[1,2,5],
//[1,7],
//[2,6]
//] 
//
// 示例 2: 
//
// 
//输入: candidates = [2,5,2,1,2], target = 5,
//输出:
//[
//[1,2,2],
//[5]
//] 
//
// 
//
// 提示: 
//
// 
// 1 <= candidates.length <= 100 
// 1 <= candidates[i] <= 50 
// 1 <= target <= 30 
// 
// Related Topics 数组 回溯 👍 877 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Soultion40 {
    public static void main(String[] args) {
        Solution solution = new Soultion40().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        List<List<Integer>> res = new ArrayList<>();
        LinkedList<Integer> track = new LinkedList<>();
        int trackSum = 0;

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            if (candidates.length == 0) {
                return res;
            }
            Arrays.sort(candidates);
            backtrack(0, target,candidates);
            return res;
        }

        void backtrack(int start, int target, int[] nums) {
            // 达到目标和
            if (trackSum == target) {
                res.add(new ArrayList<>(track));
                return;
            }
            // 超过目标和
            if (trackSum > target) {
                return;
            }

            for (int i = start; i < nums.length; i++) {
                // 剪枝,减掉的是相邻两边相等的
                if (i > start && nums[i] == nums[i - 1]) {
                    continue;
                }
                track.add(nums[i]);
                trackSum += nums[i];
                backtrack(i + 1, target, nums);
                track.removeLast();
                trackSum -= nums[i];
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
