package acwing;

import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/10/24/ 22:43
 */
public class Main786 {
    static int[] nums;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        nums = new int[n];
        for (int i = 0; i < nums.length; i++) {
            nums[i] = sc.nextInt();
        }
        quickSort(0, n - 1);
        System.out.println(nums[k - 1]);
    }

    private static void quickSort(int l, int r) {
        if (l >= r) return;

        int x = nums[l];
        int i = l - 1, j = r + 1;
        while (i < j) {
            while (nums[++i] < x) ;
            while (nums[--j] > x) ;

            if (i < j) {
                int t = nums[i];
                nums[i] = nums[j];
                nums[j] = t;
            }
        }
        System.out.println("i = " + i);
        System.out.println("j = " + j);
        quickSort(l, j);
        quickSort(j+ 1, r);
    }
}
