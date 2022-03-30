package 剑指Offer.二叉搜索树与双向链表;

import java.util.LinkedList;
import java.util.Queue;


public class Solution {
    class Node {
        public int val;
        public Node left;
        public Node right;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val,Node _left,Node _right) {
            val = _val;
            left = _left;
            right = _right;
        }
    }
    private Queue<Node> q = new LinkedList<>();
    // 中序遍历 + 辅助队列
    public Node treeToDoublyList(Node root) {
        if (root == null)
            return null;
        inorder(root);
        Node head = q.peek();
        Node cur = head, next;
        while (!q.isEmpty()){
            cur = q.poll();
            if(!q.isEmpty()){
                next = q.peek();
                cur.right = next;
                next.left = cur;
            }
        }
        cur.right=head;
        head.left =cur;
        return head;
    }

    public void inorder(Node root){
        if (root == null)
            return;
        inorder(root.left);
        q.add(root);
        inorder(root.right);
    }

}
