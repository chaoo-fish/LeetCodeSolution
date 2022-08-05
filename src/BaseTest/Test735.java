package BaseTest;

import java.util.Arrays;

/**
 * @Author chaoo
 * @Date: 2022/07/13/ 17:37
 */
public class Test735 {
    public static void main(String[] args) {
        Test735 t = new Test735();
        int[] arr = new int[]{-2,1,-2,1};
        int[] ints = t.asteroidCollision(arr);
        System.out.println(Arrays.toString(ints));
    }

    public int[] asteroidCollision(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                int index = i - 1; // 前一个位置
                while (index >= 0 && arr[index] ==0) {
                    index--;
                }
                swap(i,index+1,arr);
                continue;
            };

            int index = i - 1; // 前一个位置
            while (index >= 0 && arr[index] >= 0 && arr[i] + arr[index] < 0) {
                arr[index--] = 0;
            }
            // 找到了
            if (index < 0) { // 越界
                swap(i, index + 1, arr);
                continue;
            }
            if (arr[i] + arr[index] == 0) { // 消除
                arr[i] = 0;
                arr[index] = 0;
                continue;
            }
            if (arr[index] < 0) { // 遇到同bao
                swap(i, index + 1, arr);
                continue;
            }
            arr[i] = 0;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                arr = Arrays.copyOf(arr,i);
                break;
            }
        }
        return arr;
    }

    private void swap(int m, int n, int[] arr) {
        int temp = arr[m];
        arr[m] = arr[n];
        arr[n] = temp;
    }
}
