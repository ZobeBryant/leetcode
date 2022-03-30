package 树形dp.最长同值路径;

public class Solution {

    public class TreeNode{
        int val;
        Solution.TreeNode left;
        Solution.TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, Solution.TreeNode left, Solution.TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 状态：要连接父节点和不连接父节点
    public int longestUnivaluePath(TreeNode root) {
        if(root == null)
            return 0;
        dfs(root);
        return ans - 1;
    }
    private int ans = 0;
    public int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0, 0, Integer.MAX_VALUE};

        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[3];
        if(root.val == left[2] && root.val == right[2]){
            dp[0] = Math.max(right[0], left[0]) + 1;
            dp[1] = right[0] + left[0] + 1;
        }else if(root.val == left[2]){
            dp[0] = left[0] + 1;
            dp[1] = left[0] + 1;
        }else if(root.val == right[2]){
            dp[0] = right[0] + 1;
            dp[1] = right[0] + 1;
        }else{
            dp[0] = 1;
            dp[1] = 1;
        }
        dp[2] = root.val;
        ans = Math.max(ans, Math.max(dp[0], dp[1]));
        return dp;
    }
}
