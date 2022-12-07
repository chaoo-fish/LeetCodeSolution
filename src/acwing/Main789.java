package acwing;

import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/10/28/ 16:50
 */
public class Main789 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        while (k-- > 0) {
            int x = sc.nextInt();
            int l = 0, r = n - 1;
            while (l < r) {
                int mid = l + r >> 1;
                if (nums[mid] >= x) r = mid;
                else l = mid + 1;
            }
            if (nums[l] != x) System.out.println("-1 -1");
            else {
                int left = l;
                l = 0;
                r = n - 1;
                while (l < r) {
                    int mid = l + r + 1 >> 1;
                    if (nums[mid] <= x) l = mid;
                    else r = mid - 1;
                }
                System.out.println(left + " " + l);
            }
        }
    }
}
