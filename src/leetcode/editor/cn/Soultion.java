package leetcode.editor.cn;


/**
 * 通用模板
 */
public class Soultion {
    public static void main(String[] args) {
    }
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int totalGas = 0;
        int curGas = 0;
        int start = 0;
        for (int i = 0; i < gas.length; i++) {
            totalGas += gas[i] - cost[i];
            curGas += gas[i] - cost[i];
            if (curGas < 0) {
                start = i + 1;
                curGas = 0;
            }
        }
        if (totalGas < 0) return -1;

        return start;
    }

}
