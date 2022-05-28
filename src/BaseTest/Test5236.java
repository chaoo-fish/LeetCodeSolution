package BaseTest;

import java.util.ArrayList;

public class Test5236 {
    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2,2,3,3};
        int i = minDeletion(nums);
        System.out.println(i);
    }

    public static int minDeletion(int[] nums) {
        /**
         * 删除两个相邻一样的
         *  2   2  
         *  偶  奇
         *
         */

        int res = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (i % 2 == 0 || nums[i] != nums[i + 1]) {
                res++;
                System.out.println(nums[i]);
            }
        }
        return res;
    }
}
