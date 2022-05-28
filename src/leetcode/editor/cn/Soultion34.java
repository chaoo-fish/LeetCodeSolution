//给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。 
//
// 如果数组中不存在目标值 target，返回 [-1, -1]。 
//
// 进阶： 
//
// 
// 你可以设计并实现时间复杂度为 O(log n) 的算法解决此问题吗？ 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 8
//输出：[3,4] 
//
// 示例 2： 
//
// 
//输入：nums = [5,7,7,8,8,10], target = 6
//输出：[-1,-1] 
//
// 示例 3： 
//
// 
//输入：nums = [], target = 0
//输出：[-1,-1] 
//
// 
//
// 提示： 
//
// 
// 0 <= nums.length <= 10⁵ 
// -10⁹ <= nums[i] <= 10⁹ 
// nums 是一个非递减数组 
// -10⁹ <= target <= 10⁹ 
// 
// Related Topics 数组 二分查找 👍 1594 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion34 {
    public static void main(String[] args) {
        Solution solution = new Soultion34().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int leftMargin(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int mid = low + (high - low) / 2;
                if (nums[mid] >= target) {
                    high = mid;
                } else {
                    low = mid + 1;
                }
            }
            if (nums[low] == target) {
                return low;
            } else {
                return -1;
            }
        }

        public int rightMargin(int[] nums, int target) {
            int low = 0;
            int high = nums.length - 1;
            while (low < high) {
                int mid = (high + low + 1) / 2;
                if (nums[mid] <= target) {
                    low = mid;
                } else {
                    high = mid - 1;
                }
            }
            if (nums[high] == target) {
                return high;
            } else {
                return -1;
            }
        }

        public int[] searchRange(int[] nums, int target) {
            if (nums.length == 0 || nums[0] > target || nums[nums.length - 1] < target) {
                return new int[]{-1, -1};
            }
            int lm = leftMargin(nums, target);
            int rm = rightMargin(nums, target);
            return new int[]{lm, rm};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
