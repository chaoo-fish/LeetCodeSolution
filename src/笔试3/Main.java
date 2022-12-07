package 笔试3;

/**
 * @Author chaoo
 * @Date: 2022/09/17/ 19:13
 * 1
 */
public class Main {

    private int getVal(int[][] arr, int i, int j) {
        int nextVal = 0;
        int count = count(arr, i, j);
        int cur = arr[i][j];
        if (cur == 1 && (count == 3 || count == 2)) {
            nextVal = cur;
        }
        if (cur == 1 && count > 3) {
            nextVal = 0;
        }
        if (cur == 0 && count == 3) {
            nextVal = 1;
        }
        return nextVal;
    }

    private int count(int[][] arr, int i, int j) {

        return 0;
    }
}
