package 周赛;

class Solution4 {
    public static void main(String[] args) {
        Solution4 solution = new Solution4();
        int[][] mat = {{1,0,1,0,0,0,0,0}, {0,0,0,1,1,0,0,1}, {0,0,1,1,1,1,1,1}, {0,1,0,0,1,1,0,1}, {0,1,0,0,1,0,0,0}};
        int i = solution.maximumRows(mat, 5);
        System.out.println("i = " + i);
    }

    public int maximumRows(int[][] mat, int cols) {
        int m = mat.length;
        int n = mat[0].length;
        int state = 1 << n;
        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    arr[i] ^= (1 << j);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < state; i++) {
            if (Integer.bitCount(i) == cols) {
                 System.out.println("状态：" + Integer.toBinaryString(i));
                int count = 0;
                // 暴力 匹配
                for (int x : arr) {
                    if ((((~i) & x) << (32 - n)) == 0) {
                        count++;
                    }
                }
                res = Math.max(res, count);
            }
        }
        return res;
    }
}