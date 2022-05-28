package BaseTest;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test5268 {
    public static void main(String[] args) {

    }

    public static List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        List<List<Integer>> res = new ArrayList<>();
        HashSet<Integer> temp = new HashSet<>();

        HashSet<Integer> set1 = new HashSet<Integer>();
        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int i : nums1) {
            set1.add(i);
        }
        for (int i : nums2) {
            set2.add(i);
        }
        for (int i : nums1) {
            if (!set2.contains(i)) {
                temp.add(i);
            }
        }
        res.add(new ArrayList<>(temp));
        temp = new HashSet<>();

        for (int i : nums2) {
            if (!set1.contains(i)) {
                temp.add(i);
            }
        }
        res.add(new ArrayList<>(temp));

        return res;
    }
}
