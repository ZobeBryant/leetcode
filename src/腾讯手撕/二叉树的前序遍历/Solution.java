package 腾讯手撕.二叉树的前序遍历;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null)
            return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()){
            while (root != null){
                res.add(root.val);
                st.add(root);
                root = root.left;
            }
            root = st.pop();
            root = root.right;
        }
        return res;
    }
}
