package 周赛;

import java.util.*;

class Solution3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        List<String> words = new ArrayList<>();
        words.add("hello");
        words.add("world");

        boolean[] wordFlag = new boolean[26];
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                if (!wordFlag[word.charAt(i) - 'a']) {
                    wordFlag[word.charAt(i) - 'a'] = true;
                    sb.append(word.charAt(i));
                }
            }
        }

        String[] strings = sb.toString().split("");
        System.out.println(Arrays.toString(strings));
    }
}