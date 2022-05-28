//给定一个二叉树 
//
// 
//struct Node {
//  int val;
//  Node *left;
//  Node *right;
//  Node *next;
//} 
//
// 填充它的每个 next 指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。 
//
// 初始状态下，所有 next 指针都被设置为 NULL。 
//
// 
//
// 进阶： 
//
// 
// 你只能使用常量级额外空间。 
// 使用递归解题也符合要求，本题中递归程序占用的栈空间不算做额外的空间复杂度。 
// 
//
// 
//
// 示例： 
//
// 
//
// 
//输入：root = [1,2,3,4,5,null,7]
//输出：[1,#,2,3,#,4,5,7,#]
//解释：给定二叉树如图 A 所示，你的函数应该填充它的每个 next 指针，以指向其下一个右侧节点，如图 B 所示。序列化输出按层序遍历顺序（由 next 指
//针连接），'#' 表示每层的末尾。 
//
// 
//
// 提示： 
//
// 
// 树中的节点数小于 6000 
// -100 <= node.val <= 100 
// 
//
// 
//
// 
// 
// Related Topics 树 深度优先搜索 广度优先搜索 链表 二叉树 👍 521 👎 0

/**
 * @author sanshisi
 */
 
package leetcode.editor.cn;

import org.w3c.dom.Node;

import java.util.LinkedList;
import java.util.Queue;

public class Soultion117 {
    public static void main(String[] args) {
        Solution solution = new Soultion117().new Solution();
    }
    
    //leetcode submit region begin(Prohibit modification and deletion)
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
//        // 广度优先遍历
//        if (root == null) {
//            return null;
//        }
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(root);
//        while(!queue.isEmpty()) {
//            // 记录一下每一层的数量
//            int levelCount = queue.size();
//            // 记录前一个节点
//            Node pre = null;
//            for (int i = 0; i < levelCount; i++) {
//                // 出队
//                Node node = queue.poll();
//                // 没哟前一个节点指向他,否则就让前一个节点指向他
//                if (pre != null) {
//                    pre.next = node;
//                }
//                // 然后在让当前节点成为第一个节点
//                pre = node;
//                // 左右节点不为空就入队
//                if (node.left != null) {
//                    queue.add(node.left);
//                }
//                if (node.right != null) {
//                    queue.add(node.right);
//                }
//            }
//        }
        return root;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}
