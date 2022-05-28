package BaseTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Set;

public class Testtt {
    @Test
    public void test01() {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(8);
        list.add(10);
        if (list.get(4) > 3) {
            System.out.println("hh");
        }
        System.out.println(list);
    }

    @Test
    public void test02() {
        int t = 8;
        System.out.println(t >> 2);
        System.out.println(t);

    }

    @Test
    public void test03() {
        int[][] hh = new int[][]{{2, 1}, {2, 2}, {2, 2}};
        System.out.println(hh.length);
        System.out.println(hh[0].length);
    }

    @Test
    public void test04() {
        StringBuilder sb = new StringBuilder();
        sb.append("123456");
        System.out.println(sb.substring(1, 2));
    }

    @Test
    public void test05() {
        Map<Integer, Integer> map = new HashMap<>();

        map.put(2, 3);
        map.put(4, 5);

        System.out.println(map.get(2));
        System.out.println(map.get(3));
        System.out.println(map.containsValue(5));
    }

    @Test
    public void test06() {
//        char a = 'b';
//        System.out.println(a + 0);
//        System.out.println((char) 98);
//        System.out.println((char) 98);

        String digits = "2345";
        for (int i = 0; i < digits.length(); i++) {
            int num = Integer.parseInt(digits.charAt(i) + "");
            if (num >= 2 && num <= 6) {
                String s = (char) (97 + (num - 2)) + (char) (97 + (num - 1)) + (char) (97 + (num)) + "";
                System.out.println(s);
            }
        }
    }

    @Test
    public void test07() {
        int[] arr = new int[]{1, 2, 3};
        LinkedList<Integer> ll = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        ll.add(5);
        System.out.println(ll.contains(5));
//        System.out.println(set.contains());
    }

    @Test
    public void test08() {
        String a = "abcd";
        String b = "aefg";

        int alen = a.length();
        int blen = b.length();

        int aBin = 0;
        int bBin = 0;
        for (int i = 0; i < a.length(); i++) {
            aBin |= 1 << (a.charAt(i) - 'a');
        }
        for (int i = 0; i < b.length(); i++) {
            bBin |= 1 << (b.charAt(i) - 'a');
        }

        if ((aBin & bBin) == 0) {
            System.out.println(alen * blen);
        } else {
            System.out.println("失败");
        }
    }

    @Test
    public void test09() {
        // 二分查找求边界 找 2
        int[] nums = new int[]{1, 2, 2, 2, 2, 3, 4, 5};
        int target = 2;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = ((right - left) >> 1) + left;
            System.out.println(left);
            if (nums[mid] == target) {
//                right = mid - 1; // 找左边的,向左逼近
                left = mid + 1; // 找右边的,向右逼近
            } else if (nums[mid] > target) {
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid +1;
            }
        }
        System.out.println(right);
    }


}
