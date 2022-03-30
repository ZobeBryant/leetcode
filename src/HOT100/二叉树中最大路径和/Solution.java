package HOT100.二叉树中最大路径和;

import java.util.List;

public class Solution {
    class TreeNode{
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
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return max;
    }
    int max = Integer.MIN_VALUE;
    public int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = dfs(root.left);
        int right = dfs(root.right);
        if(left > 0 && right > 0){
            max = Math.max(left + right + root.val, max);
        }else if(left > 0){
            max = Math.max(left + root.val, max);
        }else if(right > 0){
            max = Math.max(right + root.val, max);
        }else{
            max = Math.max(root.val, max);
        }
        return Math.max(root.val, Math.max(right + root.val, left + root.val));
    }
}
