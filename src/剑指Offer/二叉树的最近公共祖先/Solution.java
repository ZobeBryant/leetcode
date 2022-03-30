package 剑指Offer.二叉树的最近公共祖先;


import java.util.Stack;

public class Solution {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        Stack<TreeNode> st_p = new Stack<>();
        Stack<TreeNode> st_q = new Stack<>();
        dfs(root, p, st_p);
        dfs(root, q, st_q);
        TreeNode ancestor = null;
        while (!st_p.isEmpty() && !st_q.isEmpty()){
            TreeNode temp_p = st_p.pop(), temp_q = st_q.pop();
            if(temp_p == temp_q)
                ancestor = temp_p;
            else
                break;
        }
        return ancestor;
    }

    public TreeNode dfs(TreeNode root, TreeNode target, Stack<TreeNode> st){
        if(root == null)
            return null;
        else if(root == target){
            st.push(root);
            return root;
        }
        TreeNode left = dfs(root.left, target, st);
        TreeNode right = dfs(root.right, target, st);

        if(left != null || right != null){
            st.push(root);
            return root;
        }
            return null;
    }
    // 第二种方法
    private TreeNode ans = null;
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs2(root, p, q);
        return ans;
    }
    public boolean dfs2(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)
            return false;
        boolean lson = dfs2(root.left, p , q);
        boolean rson = dfs2(root.right, p , q);

        if((lson && rson) || ((root.val == p.val || root.val == q.val) && (lson || rson))){
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode p = new TreeNode(2);
        p.left = null;
        p.right = null;
        TreeNode q = new TreeNode(3);
        q.left = null;
        q.right = null;
        root.left = p;
        root.right = q;
        Solution sl = new Solution();
        sl.lowestCommonAncestor(root, p, q);
    }
}
