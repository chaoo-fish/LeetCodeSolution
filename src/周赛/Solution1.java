package 周赛;

import java.util.*;

class Solution1 {
    public static void main(String[] args) {
        String s = "123";
        Solution1 s1 = new Solution1();
        s1.removeDigit(s, '3');
    }

    public String removeDigit(String number, char digit) {
        String res = "0";
        char[] chars = number.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == digit) {
                res = number.substring(0, i) + number.substring(i + 1, chars.length);
                if (i < chars.length - 1 && chars[i] < chars[i + 1]) {
                    break;
                }
            }
        }
        System.out.println(res);
        return res;
    }
}