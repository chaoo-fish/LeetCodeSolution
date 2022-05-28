package BaseTest;

public class Test1855 {
    public static void main(String[] args) {
        Test1855 test1855 = new Test1855();
        int[] nums1 = new int[]{55, 30, 5, 4, 2};
        int[] nums2 = new int[]{100, 20, 10, 10, 5};
        test1855.maxDistance(nums1, nums2);
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        // 遍历i 使用二分查找nums2中最后一个大于nums[i]的数
        // 记录距离
        /***
         5 4 3 2 1
         6
         */
        int res = -1;
        for (int i = 0; i < nums1.length; i++) {
            int l = i;
            int r = nums2.length - 1;
            int target = nums1[i];
            if (target > nums2[0]) continue;
            while (l < r) {
                // 查找区间的右边 左边界向右缩进
                int mid = l + ((r - l + 1) >> 1);
                if (nums2[mid] >= target) {
                    l = mid;
                } else {
                    r = mid - 1;
                }
            }
            res = Math.max(res, l - i);
        }


        return res;
    }

}
