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

public class Soultion215 {
    public static void main(String[] args) {
        Solution solution = new Soultion215().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int findKthLargest(int[] nums, int k) {
            // 使用快排
            int index = partition(nums, 0, nums.length - 1);
            return nums[nums.length - k];
        }

        public int partition(int[] arr, int l, int r) {
            // 快排
            if (l >= r) return l; // 边界
            swap(arr, l, (int) (l + Math.random() * (r - l + 1)));// 随机一个数和首位交换
            int v = arr[l]; // 中间数
            int lt = l;
            int gt = r + 1;
            int i = l + 1;
            while (i < gt) {
                if (arr[i] > v) {
                    swap(arr,i,lt + 1);
                    lt++;
                    i++;
                } else if (arr[i] < v) {
                    swap(arr,i,gt - 1);
                    gt--;
                }  else {
                    i++;
                }
            }
            swap(arr, l, lt);
            return lt;
        }

        public void swap(int[] nums, int a, int b) {
            //异或版本的交换需要确保两个数不相等
            if (a == b)
                return;
            nums[a] ^= nums[b]; // a 1 b 2    a = 1 ^ 2
            nums[b] ^= nums[a]; // b = 1 ^ 2 ^ 2 = 1
            nums[a] ^= nums[b]; // a = 1 ^ 2 ^ 1 = 2
        }
    }
}
