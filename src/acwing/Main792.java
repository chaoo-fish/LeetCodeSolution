package acwing;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author chaoo
 * @Date: 2022/11/18/ 23:04
 * 高精度减法
 */
public class Main792 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.next();
        String b = sc.next();
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();

        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) B.add(b.charAt(i) - '0');

        if (!cmp(A, B)) {
            System.out.print("-");
        }
       List<Integer> C =  sub(A, B);
        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }
    }

    private static boolean cmp(List<Integer> A, List<Integer> B) {
        if (A.size() != B.size()) return A.size() > B.size();
        for (int i = A.size() - 1; i >= 0; i--) {
            if (A.get(i) != B.get(i)) return A.get(i) > B.get(i);
        }
        return true;
    }

    private static List<Integer> sub(List<Integer> A, List<Integer> B) {
        if (!cmp(A, B)) {
            return sub(B, A);
        }
        List<Integer> C = new ArrayList<>();
        int t = 0;
        for (int i = 0; i < A.size(); i++) {
            t = A.get(i) - t;
            if (i < B.size()) t -= B.get(i);
            C.add((t + 10) % 10);
            if (t < 0) t = 1;
            else t = 0;
        }
        while (C.size() > 1 && C.get(C.size() - 1) == 0) C.remove(C.size() - 1);
        return C;
    }
}
