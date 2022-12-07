package acwing;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * @Author chaoo
 * @Date: 2022/10/31/ 20:36
 */
public class Main790 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        double n = Double.parseDouble(in.readLine());

        double l = -1000;
        double r = 1000;
        while (r - l > 1e-8) { // 1e-8 = 0.00000001 通过两数想减达到这个误差范围
            double mid = (l + r)/2;
            if (mid * mid * mid < n) l = mid;
            else r = mid;
        }
        System.out.printf("%.6\n",l);// 6 位小数点

    }
}
