package 二分查找.对称二叉树;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public boolean isSymmetric(TreeNode root) {
        Deque<TreeNode> q1 = new LinkedList<>();
        Deque<TreeNode> q2 = new LinkedList<>();
        q1.offer(root);
        q2.offer(root);
        // 层序遍历
        while (!q1.isEmpty() && !q2.isEmpty()){
            TreeNode n1 = q1.poll();
            TreeNode n2 = q2.poll();
            if(n1== null && n2 == null)
                continue;
            if((n1== null || n2 == null)|| n1.val != n2.val)
                return false;
            q1.offer(n1.left);
            q1.offer(n1.right);
            q2.offer(n2.right);
            q2.offer(n2.left);
        }
        if(!q1.isEmpty() || !q2.isEmpty())
            return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        Solution sl = new Solution();
        sl.isSymmetric(root);
    }
}
