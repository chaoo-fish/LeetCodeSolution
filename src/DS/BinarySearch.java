package DS;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = new int[]{-4,-2,1,4,8};
        int target = -1;
        int i = binarySearch(nums, target);
        System.out.println(i);
    }

    public static int binarySearch(int[] nums, int target) {
        // 二分查找 右边界
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) >> 1 ;
            if (nums[mid] >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
