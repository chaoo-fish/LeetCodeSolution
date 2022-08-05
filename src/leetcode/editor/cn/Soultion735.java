//给定一个整数数组 asteroids，表示在同一行的行星。 
//
// 对于数组中的每一个元素，其绝对值表示行星的大小，正负表示行星的移动方向（正表示向右移动，负表示向左移动）。每一颗行星以相同的速度移动。 
//
// 找出碰撞后剩下的所有行星。碰撞规则：两个行星相互碰撞，较小的行星会爆炸。如果两颗行星大小相同，则两颗行星都会爆炸。两颗移动方向相同的行星，永远不会发生碰撞
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：asteroids = [5,10,-5]
//输出：[5,10]
//解释：10 和 -5 碰撞后只剩下 10 。 5 和 10 永远不会发生碰撞。 
//
// 示例 2： 
//
// 
//输入：asteroids = [8,-8]
//输出：[]
//解释：8 和 -8 碰撞后，两者都发生爆炸。 
//
// 示例 3： 
//
// 
//输入：asteroids = [10,2,-5]
//输出：[10]
//解释：2 和 -5 发生碰撞后剩下 -5 。10 和 -5 发生碰撞后剩下 10 。 
//
// 
//
// 提示： 
//
// 
// 2 <= asteroids.length <= 10⁴ 
// -1000 <= asteroids[i] <= 1000 
// asteroids[i] != 0 
// 
// Related Topics 栈 数组 👍 303 👎 0

/**
 * @author sanshisi
 */

package leetcode.editor.cn;

public class Soultion735 {
    public static void main(String[] args) {
        Solution solution = new Soultion735().new Solution();
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] asteroidCollision(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] > 0) continue;

                int index = i - 1; // 前一个位置
                while (index >= 0 && arr[index] >= 0 && arr[i] + arr[index] < 0) {
                    if (arr[index--] == 0) continue;
                    arr[index] = 0;
                }
                // 找到了
                if (index < 0) { // 越界
                    swap(i, index, arr);
                    continue;
                }
                if (arr[i] + arr[index] == 0) {
                    arr[i] = 0;
                    arr[index] = 0;
                    continue;
                }
                if (arr[index] < 0) {
                    swap(i, index+1, arr);
                    continue;
                }
                arr[i] = 0;
            }

            return null;
        }

        private void swap(int m, int n, int[] arr) {
            int temp = arr[m];
            arr[m] = arr[n];
            arr[n] = temp;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
