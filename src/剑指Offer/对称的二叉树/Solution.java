package 剑指Offer.对称的二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    // 辅助队列
    public boolean isSymmetric(TreeNode root) {
        if(root == null)
            return true;
        TreeNode p = root;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(p);
        q2.offer(p);
        boolean flag = true;
        while (!q1.isEmpty()&&!q2.isEmpty()){
            TreeNode p1 = q1.poll();
            TreeNode p2 = q2.poll();
            if(p1.val != p2.val){
                flag = false;
                break;
            }
            if(p1.left!=null && p2.right!=null){
                q1.offer(p1.left);
                q2.offer(p2.right);
            }else if((p1.left == null && p2.right != null) || (p1.left != null && p2.right == null)){
                flag = false;
                break;
            }

            if(p1.right!=null && p2.left!=null){
                q1.offer(p1.right);
                q2.offer(p2.left);
            }else if((p1.right == null && p2.left != null) || (p1.right != null && p2.left == null)){
                flag = false;
                break;
            }
        }
        if(!q1.isEmpty()|| !q2.isEmpty()){
            return false;
        }
        return flag;


    }

    // 辅助队列改进
    public boolean isSymmetric2(TreeNode root) {
        return check(root,root);
    }
    public boolean check(TreeNode p1, TreeNode p2){
        Queue<TreeNode> q = new LinkedList();
        q.offer(p1);
        q.offer(p2);
        while (!q.isEmpty()){
            TreeNode u = q.poll();
            TreeNode v = q.poll();
            if(u == null && v == null)
                continue;
            if((u == null || v == null) || (u.val != v.val))
                return false;

            q.offer(u.left);
            q.offer(v.right);

            q.offer(u.right);
            q.offer(v.left);
        }
        return true;
    }
}
