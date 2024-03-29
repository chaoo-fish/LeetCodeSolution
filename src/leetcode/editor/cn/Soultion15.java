//给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有和为 0 且不重
//复的三元组。 
//
// 注意：答案中不可以包含重复的三元组。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [-1,0,1,2,-1,-4]
//输出：[[-1,-1,2],[-1,0,1]]
// 
//
// 示例 2： 
//
// 
//输入：nums = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：nums = [0]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 3000 
// -10⁵ <= nums[i] <= 10⁵ 
// 
// Related Topics 数组 双指针 排序 👍 4458 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Soultion15 {
    public static void main(String[] args) {
        Solution solution = new Soultion15().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            // 排序
            Arrays.sort(nums);
            // 双指针
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) { // 后面数都是大于0的
                    return res;
                }
                if (i > 0 && nums[i] == nums[i - 1]) { // 跳过重复的
                    continue;
                }

                int cur = nums[i];
                int L = i + 1, R = nums.length - 1;
                while (L < R) {
                    int sum = cur + nums[L] + nums[R];
                    if (sum == 0) {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(cur);
                        temp.add(nums[L]);
                        temp.add(nums[R]);
                        res.add(temp);
                        while (L < R && nums[L] == nums[L + 1]) { // 跳过后面重复的
                            L++;
                        }
                        while (L < R && nums[R] == nums[R - 1]) {
                            R--;
                        }
                        L++;
                        R--;
                    } else if (sum < 0) {
                        L++;
                    } else {
                        R--;
                    }
                }
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
