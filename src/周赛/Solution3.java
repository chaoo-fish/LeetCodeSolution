package 周赛;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution3 {
    public static void main(String[] args) {
//        int[][] mat = {{0, 0, 0}, {1, 0, 1}, {0, 1, 1}, {0, 0, 1}};
        //[[1,0,1,0,0,0,0,0],[0,0,0,1,1,0,0,1],[0,0,1,1,1,1,1,1],[0,1,0,0,1,1,0,1],[0,1,0,0,1,0,0,0]]
        //5
//        int[][] mat = {{1,0,1,1,1,1}, {1,1,0,0,0,0}, {0,0,1,1,0,1}};
        int[][] mat = {{1,0,1,0,0,0,0,0}, {0,0,0,1,1,0,0,1}, {0,0,1,1,1,1,1,1}, {0,1,0,0,1,1,0,1}, {0,1,0,0,1,0,0,0}};
        int i = new Solution3().maximumRows(mat, 5);
        System.out.println("i = " + i);
    }

    public int maximumRows(int[][] mat, int cols) {
        int[] count = new int[mat[0].length];
        for (int[] m : mat) {
            int sum = 0;
            for (int i : m) sum += i;
            if (sum>cols) continue;
            for (int i = 0; i < m.length; i++) {
                count[i] += m[i];
            }
            System.out.println(Arrays.toString(m));
        }
        System.out.println("=========================");

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> b[0] - a[0]); //
        for (int i = 0; i < count.length; i++) {
            pq.add(new int[]{count[i], i});
        }
        while (cols != 0) {
            int[] re = pq.remove();
            for (int i = 0; i < mat.length; i++) {
                mat[i][re[1]] = 0;
            }
            cols--;
        }

        int res = 0;
        for (int[] m : mat) {
            System.out.println(Arrays.toString(m));
            boolean f= false;
            for (int i = 0; i < m.length; i++) {
                if (m[i] == 1){
                    f = true;
                    break;
                }
            }
            if (f) continue;
            res++;
        }


        return res;
    }
}