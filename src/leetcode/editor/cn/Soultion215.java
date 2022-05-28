//给定整数数组 nums 和整数 k，请返回数组中第 k 个最大的元素。 
//
// 请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例 1: 
//
// 
//输入: [3,2,1,5,6,4] 和 k = 2
//输出: 5
// 
//
// 示例 2: 
//
// 
//输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
//输出: 4 
//
// 
//
// 提示： 
//
// 
// 1 <= k <= nums.length <= 10⁴ 
// -10⁴ <= nums[i] <= 10⁴ 
// 
// Related Topics 数组 分治 快速选择 排序 堆（优先队列） 👍 1617 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Properties;

public class Soultion215 {
    public static void main(String[] args) {
        Solution solution = new Soultion215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 3.partition算法
        /*
            这个算法是一种分类算法,将一个序列分成两个部分
         */
            int len = nums.length;
            int left = 0;
            int right = len - 1;
            int target = len - k;

            while (true) {
                int index = partition(nums, left, right);
                if (index == target) {
                    return index;
                } else if (index > target) {
                    right = index - 1;
                } else {
                    left = index + 1;
                }
            }


        }

        private int partition(int[] nums, int left, int right) {
            int pivot = nums[left];
            int j = left;
            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot){
                    j++;
                    swap(nums,j,i);
                }
            }
            swap(nums,j,left);
            return j;
        }

        private void swap(int[] nums, int index1, int index2) {
            int temp = nums[index1];
            nums[index1] = nums[index2];
            nums[index2] = temp;
        }

    }

}
