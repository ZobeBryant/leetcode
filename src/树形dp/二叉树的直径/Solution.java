package 树形dp.二叉树的直径;

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
    // 树形dp
    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return ans - 1;
    }
    private int ans = 0;
    // 状态：当前节点连接父节点和不连接父节点
    public int[] dfs(TreeNode root){
        if(root == null)
            return new int[]{0,0};
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[2];

        dp[0] = Math.max(left[0], right[0]) + 1;
        dp[1] = left[0] + right[0] + 1;
        ans = Math.max(ans, Math.max(dp[0], dp[1]));
        return dp;
    }

    // 错误 类似计算树的高度
    public int diameterOfBinaryTree2(TreeNode root) {
        return treeHeight(root);
    }
    public int treeHeight(TreeNode root){
        if(root == null){
            return 0;
        }

        return Math.max(treeHeight(root.left),treeHeight(root.right)) + 1;
    }
}
