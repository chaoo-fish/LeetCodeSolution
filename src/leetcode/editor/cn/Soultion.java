package leetcode.editor.cn;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 通用模板
 */
public class Soultion {
    public static void main(String[] args) {
    }

    public int findClosest(String[] words, String word1, String word2) {
        int res =  100000;
        int start =  100000;
        int end =  100000;
        for(int i = 0; i < words.length; i++) {
            String cur = words[i];
            if(cur.equals(word1)){
                start = i;
            } else if(cur.equals(word2)){
                end = i;
            }
            res = Math.min(res,Math.abs(end - start));
        }
        return res;
    }
}
