package acwing;

import java.util.ArrayList;
import java.util.Scanner;


/**
 * @Author chaoo
 * @Date: 2022/09/28/ 14:20
 */
public class Main791 {
    static ArrayList<Integer> C = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        ArrayList<Integer> A = new ArrayList<>();
        ArrayList<Integer> B = new ArrayList<>();

        for (int i = a.length() - 1; i >= 0; i--) A.add(a.charAt(i) - '0');
        for (int i = b.length() - 1; i >= 0; i--) B.add(b.charAt(i) - '0');

        add(A, B);

        for (int i = C.size() - 1; i >= 0; i--) {
            System.out.print(C.get(i));
        }
    }

    private static void add(ArrayList<Integer> A, ArrayList<Integer> B) {
        int t = 0;
        for (int i = 0; i < Math.max(A.size(), B.size()); i++) {
            if (i < A.size()) t += A.get(i);
            if (i < B.size()) t += B.get(i);
            C.add(t % 10);
            t /= 10;
        }
        if (t != 0) C.add(1);
    }
}