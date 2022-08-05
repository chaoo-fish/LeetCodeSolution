//存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中 没有重复出现 的数字。 
//
// 返回同样按升序排列的结果链表。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,3,4,4,5]
//输出：[1,2,5]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,1,1,2,3]
//输出：[2,3]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点数目在范围 [0, 300] 内 
// -100 <= Node.val <= 100 
// 题目数据保证链表已经按升序排列 
// 
// Related Topics 链表 双指针 👍 779 👎 0

/**
 * @author sanshisi
 */
package leetcode.editor.cn;

import DS.ListNode;

public class Soultion82 {
    public static void main(String[] args) {
        Solution solution = new Soultion82().new Solution();
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            if (head == null && head.next == null) {
                return head;
            }

            ListNode vir = new ListNode(0);
            vir.next = head;



            ListNode pre = vir;
            ListNode cur = pre.next;
            while (cur != null && cur.next != null) {
                if (cur.val != cur.next.val) {
                    pre = cur;
                    cur = cur.next;
                } else {
                    ListNode next = cur.next.next;
                    while (next != null && next.val == cur.val) {
                        next = next.next;
                    }
                    pre.next = next;
                    cur = next;
                }
            }



            return vir.next;
        }
    }


//    class Solution {
//        public ListNode deleteDuplicates(ListNode head) {
//            if (head == null || head.next == null) {
//                return head;
//            }
//
//            ListNode vir = new ListNode(0);
//            vir.next = head;
//
//            ListNode pre = vir;
//            ListNode cur = vir.next;
//
//            while (cur != null && cur.next != null) {
//                if (cur.val != cur.next.val) {
//                    pre = cur;
//                    cur = cur.next;
//                } else {
//                    ListNode next = cur.next.next;
//                    while (next != null && next.val == cur.val) {
//                        next = next.next;
//                    }
//                    pre.next = next;
//                    cur = next;
//                }
//            }
//
//            return vir.next;
//
//        }
//    }


//    class Solution {
//        public ListNode deleteDuplicates(ListNode head) {
//            if (head == null || head.next == null) {
//                return head;
//            }
//
//            if (head.val != head.next.val) {
//                head.next = deleteDuplicates(head.next);
//                return head;
//            } else {
//                ListNode next = head.next.next;
//                while (next != null && next.val == head.val) {
//                    next = next.next;
//                }
//                return deleteDuplicates(next);
//            }
//        }
//    }
//leetcode submit region end(Prohibit modification and deletion)

}
