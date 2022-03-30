package 剑指Offer.平衡二叉树;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private  boolean flag = true;
    public boolean isBalanced(TreeNode root) {
        balance(root);
        return flag;
    }
    public int balance(TreeNode root){
        if(root == null)
            return 0;
        int left = balance(root.left) + 1;
        int right = balance(root.right) + 1;
        if(Math.abs(left-right) > 1){
            flag = false;
        }

        return Math.max(left, right);
    }

}
