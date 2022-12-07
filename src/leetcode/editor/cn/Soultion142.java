//给定一个链表,返回链表开始入环的第一个节点. 如果链表无环,则返回 null. 
//
// 如果链表中有某个节点,可以通过连续跟踪 next 指针再次到达,则链表中存在环. 为了表示给定链表中的环,评测系统内部使用整数 pos 来表示链表尾连接到
//链表中的位置(索引从 0 开始).如果 pos 是 -1,则在该链表中没有环.注意:pos 不作为参数进行传递,仅仅是为了标识链表的实际情况. 
//
// 不允许修改 链表. 
//
// 
// 
//
// 
//
// 示例 1: 
//
// 
//
// 
//输入:head = [3,2,0,-4], pos = 1
//输出:返回索引为 1 的链表节点
//解释:链表中有一个环,其尾部连接到第二个节点.
// 
//
// 示例 2: 
//
// 
//
// 
//输入:head = [1,2], pos = 0
//输出:返回索引为 0 的链表节点
//解释:链表中有一个环,其尾部连接到第一个节点.
// 
//
// 示例 3: 
//
// 
//
// 
//输入:head = [1], pos = -1
//输出:返回 null
//解释:链表中没有环.
// 
//
// 
//
// 提示: 
//
// 
// 链表中节点的数目范围在范围 [0, 10⁴] 内 
// -10⁵ <= Node.val <= 10⁵ 
// pos 的值为 -1 或者链表中的一个有效索引 
// 
//
// 
//
// 进阶:你是否可以使用 O(1) 空间解决此题? 
// Related Topics 哈希表 链表 双指针 👍 1323 👎 0

/**
 * @author sanshisi
 */
package leetcode.editor.cn;

import DS.ListNode;

public class Soultion142 {
    public static void main(String[] args) {
        Solution solution = new Soultion142().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        /**
          * f: 快指针走的路
         * s: 慢指针走的路
         * b: 环的长度
         * 于是快指针走的路可以写成
         * f = 2s
         * f = s + nb
         * 
         * --->
         * 
         * s = nb;
         * 
         * 让 f 和 s 再走一段不是环的路 a 
         * s = a + nb 也即 s 和 f 在环的入口处相遇
         */
        ListNode fast = head, slow = head;
        while(true) {
            if(fast ==null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) break;
        }
        fast = head;
        while(slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
