package BaseTest;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /**
         * 4
         * 1 2 4 6
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            //
            if (i + 2 < n && i + 1 < n) {
                while (arr[i] >= 1 && arr[i + 1] >= 2 && arr[i + 2] >= 3) {
                    res += 5;
                    arr[i]--;
                    arr[i + 1] -= 2;
                    arr[i + 2] -= 3;
                }
            } // 1 1 2 4 6
            res += arr[i];
        }

        System.out.println(res);
    }
}