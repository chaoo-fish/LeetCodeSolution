package 周赛;

import java.util.*;

class Solution1 {
    public static void main(String[] args) {
        int nums[] = new int[]{1,3,5,2,4,8,2,2};
//        int nums[] = new int[]{93,40};
        int i = minMaxGame(nums);
        System.out.println(i);
    }

    public static int minMaxGame(int[] nums) {
        if (nums.length == 1) return nums[0];
        int[] temp = nums;
        int[] newNums = new int[999];
        while (newNums.length != 1) {
            newNums = new int[temp.length / 2 + temp.length % 2];
            boolean flag = true;
            for (int i = 0; i < temp.length; i++) {
                if (i + 1 == temp.length) {
                    newNums[i / 2] = temp[i];
                    break;
                }
                if (flag) {
                    newNums[i / 2] = Math.min(temp[i],temp[i +1]);
                    flag = false;
                } else {
                    newNums[i / 2] = Math.max(temp[i],temp[i +1]);
                    flag = true;
                }
                i++;
            }
            System.out.println(Arrays.toString(newNums));
            temp = newNums;
        }
        return temp[0];
    }
}