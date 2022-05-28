package BaseTest;

import java.util.HashMap;
import java.util.Set;

public class Test567 {
    public static void main(String[] args) {
        String s1 = "adc";
        String s2 = "dcda";
        boolean b = checkInclusion(s1, s2);
        System.out.println(b);
    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        HashMap<Character, Integer> hm1 = new HashMap<>();
        HashMap<Character, Integer> hm2 = new HashMap<>();
        char[] c1 = s1.toCharArray();
        char[] c2 = s2.toCharArray();

        for (char c : c1) {
            hm1.put(c, hm1.getOrDefault(c, 0) + 1);
        }

        Set<Character> keySet = hm1.keySet();
        int end = 0;
        for (end = 0; end < s1.length() - 1; end++) {
            hm2.put(c2[end], hm2.getOrDefault(c2[end], 0) + 1);
        }

        boolean flag = false;
        for (int start = 0; end < s2.length(); end++,start++) {
            hm2.put(c2[end],hm2.getOrDefault(c2[end],0) + 1); // 每次end向后移动,添加元素
            System.out.println(hm2.toString());
            flag = true;
            // 判断是否
            for(char key : keySet) {
                if (hm2.get(key) != hm1.get(key)) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                return flag;
            }
            hm2.put(c2[start],hm2.get(c2[start]) - 1); // 删除start位置元素,之后再向后移动
        }
        return flag;
    }
}
