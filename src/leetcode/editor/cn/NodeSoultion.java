package leetcode.editor.cn;

/**
 * @Author chaoo
 * @Date: 2022/12/21/ 20:34
 */


public class NodeSoultion {
    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode first = head;
        ListNode sec = head.next;
        while (sec != null && sec.next != null && sec.next.next != null) {
            if (first == sec) return true;
            first = first.next;
            sec = sec.next.next;
        }
        return false;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}