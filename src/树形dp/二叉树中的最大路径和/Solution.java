package 树形dp.二叉树中的最大路径和;

import org.omg.CORBA.MARSHAL;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 遍历到最后一个节点
    public int maxPathSum(TreeNode root) {
        dfs(root);
        return ans;
    }

    private int ans = Integer.MIN_VALUE;
    //定义状态 dp[0] 连父节点 dp[1] 不连父节点
    public int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0,0};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[2];
        // 连父节点
        if(left[0] < 0 && right[0]<0)
            dp[0] = root.val;
        else
            dp[0] = Math.max(left[0],right[0]) + root.val;
        dp[1] = left[0] + right[0] +root.val;
        ans = Math.max(ans, dp[1]);
        ans = Math.max(ans, dp[0]);
        return dp;
    }
}
