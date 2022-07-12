package BaseTest.排序;

import java.util.Arrays;

/**
 * @Author chaoo
 * @Date: 2022/07/11/ 18:37
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] arr = new int[]{3,4,2,1,5,6,7,8,8,4,4};
        q.partition(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void partition(int[] arr, int l, int r) {
        // 快排
        if (l >= r) return ; // 边界
        swap(arr,l,(int)(l + Math.random() * (r - l + 1)));// 随机一个数和首位交换
        int v = arr[l]; // 中间数
        int lt = l;
        int gt = r + 1;
        int i = l + 1;
        while (i < gt) {
            if (arr[i] > v) {
                swap(arr,i,lt + 1);
                lt++;
                i++;
            } else if (arr[i] < v) {
                swap(arr,i,gt - 1);
                gt--;
            }  else {
                i++;
            }
        }
        swap(arr,l,lt);
        partition(arr,l, lt - 1);
        partition(arr,gt, r);
    }


    public void swap(int[] nums,int a,int b){
        //异或版本的交换需要确保两个数不相等
        if(a == b)
            return;
        nums[a] ^= nums[b]; // a 1 b 2    a = 1 ^ 2
        nums[b] ^= nums[a]; // b = 1 ^ 2 ^ 2 = 1
        nums[a] ^= nums[b]; // a = 1 ^ 2 ^ 1 = 2
    }

}
