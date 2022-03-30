package 腾讯手撕.二叉树的中序遍历;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while (root != null || !st.isEmpty()){
            while (root != null){
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            res.add(root.val);
            root = root.right;
        }
        return res;
    }
}
