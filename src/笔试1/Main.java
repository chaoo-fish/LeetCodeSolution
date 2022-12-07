package 笔试1;


import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/09/27/ 19:00
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        if (str1 == null || str2 == null || str1.length() < str2.length()) {
            System.out.println(0);
        } else {
            char[] chas1 = str1.toCharArray();
            char[] chas2 = str2.toCharArray();
            int[] map = new int[256];
            for (int i = 0; i < chas2.length; i++) {
                map[chas2[i]]++;
            }
            int left = 0;
            int right = 0;
            int minLen = Integer.MAX_VALUE;
            int match = chas2.length;
            while (right != chas1.length) {
                map[chas1[right]]--;
                if (map[chas1[right]] >= 0) {
                    match--;
                }
                if (match == 0) {
                    while (map[chas1[left]] < 0) {
                        map[chas1[left++]]++;
                    }
                    minLen = Math.min(minLen, right - left + 1);
                    match++;
                    map[chas1[left++]]++;
                }
                right++;
            }
            System.out.println(minLen == Integer.MAX_VALUE ? 0 : minLen);
        }

    }
}