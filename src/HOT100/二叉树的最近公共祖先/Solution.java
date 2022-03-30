package HOT100.二叉树的最近公共祖先;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private TreeNode ancestor = null;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ancestor;
    }
    // 后序遍历
    public Boolean dfs(TreeNode root, TreeNode p, TreeNode q){
        if(root == null) return false;
        Boolean left = dfs(root.left, p, q);
        Boolean right = dfs(root.right, p, q);
        if(left && right || (root == p || root == q) && (left || right)){
            ancestor = root;
        }
        return left || right || (root == p || root == q);
    }
}
