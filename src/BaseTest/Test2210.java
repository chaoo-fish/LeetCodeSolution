package BaseTest;

public class Test2210 {
    public static void main(String[] args) {
        int[] nums = new int[]{6,6,5,5,4,1};
        int i = countHillValley(nums);
//        System.out.println(i);

    }

    public static int countHillValley(int[] nums) {
        int res = 0;
        if (nums.length <= 2) {
            return res;
        }
        int pre = 0, cur = 0, l = 0, r = 0;
        for (int i = 1; i <= nums.length - 2; i++) {
            cur = nums[i];
            if (cur == pre) {
                continue;
            }
            l = i;
            while (l > 0 && nums[i] == nums[l]) {
                --l;
            }
            r = i;
            while (r < nums.length - 1 && nums[i] == nums[r]) {
                ++r;
            }

            if ((cur > nums[l] && cur > nums[r]) || (cur < nums[l] && cur < nums[r])) {
                ++res;
                System.out.println(nums[i]);
            }

            pre = cur;
        }
        return res;
    }
}
