package BaseTest;

public class Test1351 {
    public static void main(String[] args) {
        int[] nums = new int[]{3, 2, 1};
        binarySearch(nums);
    }

    public static int binarySearch(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        while (l < r) {
            int mid = (l + r) >> 1;
            if (nums[mid] <= -1) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        System.out.println(nums[l] <= -1 ? l : -1);
        return nums[l] <= -1 ? l : -1;
    }
}
