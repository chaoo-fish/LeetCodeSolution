package acwing;

import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/10/26/ 20:39
 */
public class Main787 {
    static int[] tmp;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        tmp = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        mergeSort(nums, 0, n - 1);

        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    private static void mergeSort(int[] nums, int l, int r) {
        if (l >= r) return;
        int mid = l + r >> 1;

        mergeSort(nums, l, mid);
        mergeSort(nums, mid + 1, r);

        int k = 0, i = l, j = mid + 1;
        while (i <= mid && j <= r) {
            if (nums[i] <= nums[j]) tmp[k++] = nums[i++];
            else tmp[k++] = nums[j++];
        }
        while (i <= mid) tmp[k++] = nums[i++];
        while (j <= r) tmp[k++] = nums[j++];
        for (i = l, j = 0; i <= r; i++, j++) nums[i] = tmp[j];
    }
}
