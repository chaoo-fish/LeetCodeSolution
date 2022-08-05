package 周赛;

import leetcode.editor.cn.Soultion1;

class Solution1 {
    public static void main(String[] args) {
        Soultion1 s1 = new Soultion1();
    }

    public int[] numberOfPairs(int[] nums) {
        int[] arr = new int[103];
        for (int num : nums) {
            arr[num]++;
        }
        int count = 0;
        int last =0 ;

        for (int i : arr) {
            count += i / 2;
            last += i % 2;
        }
        return  new int[]{count,last};
    }
}