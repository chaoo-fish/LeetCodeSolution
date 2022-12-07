package acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/11/19/ 9:23
 */
public class Main793 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        int b = sc.nextInt();
        ArrayList<Integer> A = new ArrayList<>();

        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');

        List<Integer> C = mul(A, b);

        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }
    }

    private static List<Integer> mul(ArrayList<Integer> A, int b) {
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size() || t != 0; i++) {
            if (i < A.size()) t += A.get(i) * b;
            C.add(t % 10);
            t /= 10;
        }
        while (C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);
        return C;
    }
}
