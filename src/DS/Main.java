package DS;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] my = new int[n + 1];
        my[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            my[i] = sc.nextInt();
        }

        int[] enemy = new int[n + 1];
        enemy[0] = 0;
        for (int i = 1; i < n + 1; i++) {
            enemy[i] = sc.nextInt();
        }
        /*
            前缀和
         */
        int money = 0;
        for (int i = 1; i < n + 1; i++) {
            my[i] += my[i - 1] + money;
            enemy[i] += enemy[i - 1];
            if (my[i] + money <= enemy[i]) {
                money += enemy[i] - my[i];
                money++;
            }
        }
        System.out.println(money);
    }
}
