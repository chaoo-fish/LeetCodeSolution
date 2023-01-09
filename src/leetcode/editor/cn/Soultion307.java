////给你一个数组 nums ，请你完成两类查询。 
////
//// 
//// 其中一类查询要求 更新 数组 nums 下标对应的值 
//// 另一类查询要求返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的nums元素的 和 ，其中 left <= right 
//// 
////
//// 实现 NumArray 类： 
////
//// 
//// NumArray(int[] nums) 用整数数组 nums 初始化对象 
//// void update(int index, int val) 将 nums[index] 的值 更新 为 val 
//// int sumRange(int left, int right) 返回数组 nums 中索引 left 和索引 right 之间（ 包含 ）的
//nums元
////素的 和 （即，nums[left] + nums[left + 1], ..., nums[right]） 
//// 
////
//// 
////
//// 示例 1： 
////
//// 
////输入：
////["NumArray", "sumRange", "update", "sumRange"]
////[[[1, 3, 5]], [0, 2], [1, 2], [0, 2]]
////输出：
////[null, 9, null, 8]
////
////解释：
////NumArray numArray = new NumArray([1, 3, 5]);
////numArray.sumRange(0, 2); // 返回 1 + 3 + 5 = 9
////numArray.update(1, 2); // nums = [1,2,5]
////numArray.sumRange(0, 2); // 返回 1 + 2 + 5 = 8
//// 
////
//// 
////
//// 提示： 
////
//// 
//// 1 <= nums.length <= 3 * 10⁴ 
//// -100 <= nums[i] <= 100 
//// 0 <= index < nums.length 
//// -100 <= val <= 100 
//// 0 <= left <= right < nums.length 
//// 调用 update 和 sumRange 方法次数不大于 3 * 10⁴ 
//// 
//// Related Topics 设计 树状数组 线段树 数组 👍 435 👎 0
//

/**
 * @author sanshisi
 */

package leetcode.editor.cn;


public class Soultion307 {
    public static void main(String[] args) {

    }

    //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {
        Node[] tr;

        class Node {
            int l, r, v;

            Node(int _l, int _r) {
                l = _l;
                r = _r;
            }
        }

        void build(int u, int l, int r) {
            tr[u] = new Node(l, r);
            if (l == r) {
                return;
            }
            int mid = l + r >> 1;
            build(u << 1, 1, mid);
            build(u << 1 | 1, mid + 1, r);
        }

        void update(int u, int x, int v) {
            if (tr[u].l == x && tr[u].r == x) {
                tr[u].v += v;
                return;
            }
            int mid = tr[u].l + tr[u].r >> 1;
            if(x <= mid) {
                update(u << 1,x ,v);
            } else{
                update(u << 1 | 1 , x, v);
            }
            pushup(u);
        }

        int query(int u, int l, int r) {
            if (l <= tr[u].l && tr[u].r <= r) {
                return tr[u].v;
            }
            int mid = tr[u].l + tr[u].r >> 1;
            int ans = 0;
            if (l <= mid) {
                ans += query(u << 1, l, r);
            }
            if (r > mid) {
                ans += query(u << 1 | 1, l, r);
            }
            return ans;
        }

        void pushup(int u) {
            tr[u].v = tr[u << 1].v + tr[u << 1 | 1].v;
        }

        int[] nums;

        public NumArray(int[] _nums) {
            nums = _nums;
            int n = nums.length;
            tr = new Node[n * 4];
            build(1, 1, n);
            for (int i = 0; i < n; i++) {
                update(1, i + 1, nums[i]);
            }
        }

        public void update(int index, int val) {
            update(1, index + 1, val - nums[index]);
            nums[index] = val;
        }

        public int sumRange(int left, int right) {
            return query(1, left + 1, right + 1);
        }
    }

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(index,val);
 * int param_2 = obj.sumRange(left,right);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
