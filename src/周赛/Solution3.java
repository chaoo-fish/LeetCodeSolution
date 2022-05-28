package 周赛;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        int[] nums = new int[]{10,2,17,7,20};
        System.out.println(s.countDistinct(nums, 1, 10));
        Set<ArrayList<Integer>> set = new HashSet<>();

    }


    public int countDistinct(int[] nums, int k, int p) {
        Set<ArrayList<Integer>> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            ArrayList<Integer> array = new ArrayList<>();
            int kk = 0;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] % p == 0) {
                    kk++;
                }
                if (kk > k) break;
                if (k > 0) {
                    array.add(nums[j]);
                    set.add(new ArrayList<>(array));
                }
            }
        }
        for (ArrayList<Integer> list : set) {
            System.out.println(list.toString());
        }
        return set.size();
    }

}