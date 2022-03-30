package 树形dp.二叉树中的最长交错路径;

public class Solution {
    public class TreeNode{
        int val;
       Solution.TreeNode left;
       Solution.TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val,Solution.TreeNode left,Solution.TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 状态：dp[0]由左子树连接上来的节点数量；dp[1]由右子树连接上来的节点数量;
    public int longestZigZag(TreeNode root) {
        dfs(root);
        return ans - 1;
    }
    private int ans = 0;
    public int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0,0};
        int[] left = dfs(root.left);
        int[] right =dfs(root.right);
        int[] dp = new int[2];
        if(left[1] > 0 )
            dp[0] = left[1] + 1;
        else
            dp[0] = 1;
        if(right[0] > 0)
            dp[1] = right[0] + 1;
        else
            dp[1] = 1;
        ans = Math.max(ans, Math.max(dp[0], dp[1]));
        return dp;
    }
}
