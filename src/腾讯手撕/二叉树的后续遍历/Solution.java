package 腾讯手撕.二叉树的后续遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    class TreeNode{
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
    // 递归
    public List<Integer> postorderTraversal(TreeNode root) {
        postOrder(root);
        return res;
    }
    private List<Integer> res = new ArrayList<>();
    public void postOrder(TreeNode root){
        if(root == null)
            return;
        postOrder(root.left);
        postOrder(root.right);
        res.add(root.val);
    }

    // 栈
    public List<Integer> postorderTraversal2(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        TreeNode pre = null;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()){
            while (root != null){
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            if(root.right == null || root.right == pre){
                res.add(root.val);
                pre = root;
                root = null;
            }else{
                st.add(root);
                root = root.right;
            }
        }
        return res;
    }
}
