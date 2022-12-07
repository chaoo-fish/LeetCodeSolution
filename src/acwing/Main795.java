package acwing;

import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/09/30/ 20:32
 */
public class Main795 {
    static int N = 100000 + 10;

    public static void main(String[] args) {
        int[] nums = new int[N];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            nums[i] = nums[i - 1] + sc.nextInt();
        }
        while (k-- > 0) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            System.out.println(nums[b] - nums[a - 1]);
        }

    }
}
