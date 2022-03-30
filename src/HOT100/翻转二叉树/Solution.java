package HOT100.翻转二叉树;

public class Solution {

    public static class TreeNode{
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
    public TreeNode invertTree1(TreeNode root) {
        if(root == null)
            return null;
        TreeNode rev = new TreeNode();
        dfs(root, rev);
        return rev;
    }
    public void dfs(TreeNode root, TreeNode rev){
        if(root == null){
            return ;
        }
        rev.val = root.val;
        if(root.right != null)
            rev.left = new TreeNode();
        if(root.left != null)
            rev.right = new TreeNode();
        dfs(root.left, rev.right);
        dfs(root.right, rev.left);
    }

    public TreeNode invertTree(TreeNode root) {
        if(root == null)
            return null;
        // 后序遍历 先交换叶子节点
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        Solution sl = new Solution();
        sl.invertTree(root);
    }
}
