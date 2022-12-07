package 笔试0;

import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/09/17/ 15:32
 */
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String numStr = sc.nextLine();
        int k = sc.nextInt();
        String ks = k + "";
        int res = 0;
        for (int i = 0; i < numStr.length(); i++) {
            int index = 0;
            // 当前值
            int now = Integer.parseInt(numStr.charAt(i) + "");
            while (index < ks.length() && now < k) {
                res++;
                index++;
                if (i + index + 1 >= numStr.length()) break;
                now = Integer.parseInt(numStr.substring(i,i + index + 1));
            }
        }
        System.out.println(res);
    }
}
