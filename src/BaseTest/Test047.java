package BaseTest;

import java.util.*;

public class Test047 {

    public static void main(String[] args) {
        Test047 t = new Test047();
        int[] nums = new int[]{1,2,3};
        System.out.println(t.permuteUnique(nums));
    }
    Set<int[]> set = new HashSet<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        dfs(nums, 0, nums.length - 1);
        for (int[] arr : set) {
            List<Integer> temp = new ArrayList<>();
            for (int a : arr) {
                temp.add(a);
            }
            list.add(temp);
        }
        return list;
    }

    void dfs(int[] nums, int start, int end) {
        if (start == end) {
            set.add(nums);
        } else {
            for (int i = start; i <= end; i++) {
                swap(i, start, nums);
                dfs(nums, i+1, end);
                System.out.println(Arrays.toString(nums));
                swap(i, start, nums);
            }
        }
    }

    void swap(int i, int start, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[start];
        nums[start] = temp;
    }
}
