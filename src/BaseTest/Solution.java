package BaseTest;


import java.util.Arrays;

/**
 * 通用模板
 */

class Solution {
    public static void main(String[] args) {
        String[] orders = {"acbad","abadac","acaba"};
        String s = new Solution().commonProduct(orders);
        System.out.println(s);
    }
    public String commonProduct(String[] orders) {
        int[] count = new int[26];
        Arrays.fill(count,Integer.MAX_VALUE);
        for (String order : orders) {
            int[] temp = new int[26];
            for (int i = 0; i < order.length(); i++) {
                temp[order.charAt(i) - 'a']++;
            }
            for (int i = 0; i < count.length; i++) {
                if (temp[i] < count[i]) count[i] = temp[i];
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count.length; i++) {
            if (count[i] != 0) {
                while (count[i]-- > 0) sb.append((char) ('a' + i));
            }
        }
        return sb.toString();
    }
}
