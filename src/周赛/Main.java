package 周赛;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int end = 0;
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isLetter(c) || c == ' '){
                curLen++;
            } else {
                curLen = 0;
            }
            if (curLen > maxLen){
                maxLen = curLen;
                end = i;
            }
        }
        System.out.println(end);
        System.out.println(maxLen);
        System.out.println(s.substring(end - maxLen + 1,end + 1));

    }
}