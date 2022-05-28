package 周赛;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int num = scanner.nextInt();
        int n = s.length();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int x = i;
            while (x < n) {
                sb.append(s.charAt(x));
                System.out.println(sb.toString());
                System.out.println((Integer.parseInt(sb.toString()) % num) == 0);
                System.out.println("======");
                x++;
            }
        }
    }
}
