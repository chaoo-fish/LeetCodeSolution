package acwing;

import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/10/17/ 20:26
 */
public class Main785 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        // 双路快排
        quickSort(arr, 0, n - 1);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }

    private static void quickSort(int[] arr, int l, int r) {
        // 截止条件
        if (l >= r) return;
        int x = arr[l]; // 随便选一个基准点
        int i = l - 1, j = r + 1;
        while (i < j) {
            while (arr[++i] < x) ;
            while (arr[--j] > x) ;
            if (i < j) { // 进行交换
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        quickSort(arr, l, j);
        quickSort(arr, j + 1, r);
    }


}
