//给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的
// 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。 
//
// candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。 
//
// 对于给定的输入，保证和为 target 的不同组合数少于 150 个。 
//
// 
//
// 示例 1： 
//
// 
//输入：candidates = [2,3,6,7], target = 7
//输出：[[2,2,3],[7]]
//解释：
//2 和 3 可以形成一组候选，2 + 2 + 3 = 7 。注意 2 可以使用多次。
//7 也是一个候选， 7 = 7 。
//仅有这两种组合。 
//
// 示例 2： 
//
// 
//输入: candidates = [2,3,5], target = 8
//输出: [[2,2,2,2],[2,3,3],[3,5]] 
//
// 示例 3： 
//
// 
//输入: candidates = [2], target = 1
//输出: []
// 
//
// 
//
// 提示： 
//
// 
// 1 <= candidates.length <= 30 
// 1 <= candidates[i] <= 200 
// candidate 中的每个元素都 互不相同 
// 1 <= target <= 500 
// 
// Related Topics 数组 回溯 👍 1838 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;

public class Soultion39 {
    public static void main(String[] args) {
        Solution solution = new Soultion39().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        List<List<Integer>> res = new LinkedList<>();
        // 记录回溯的路径
        LinkedList<Integer> track = new LinkedList<>();
        // 记录 track 中的路径和
        int trackSum = 0;

        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            /**
             * 回溯算法
             */
            if (candidates.length == 0) {
                return null;
            }
            backTrack(0, candidates, target);
            return res;
        }

        private void backTrack(int start, int[] candidates, int target) {
            // 回溯终止条件
            if (target == trackSum) {
                res.add(new LinkedList<>(track));
                return;
            }
            //
            if (trackSum > target) {
                return;
            }
            for (int i = start; i < candidates.length; i++) {
                // 开启
                trackSum += candidates[i];
                track.add(candidates[i]);
                backTrack(i + 1, candidates, target);
                // 回溯
                trackSum -= candidates[i];
                track.remove(track.size() - 1);
            }
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

}
