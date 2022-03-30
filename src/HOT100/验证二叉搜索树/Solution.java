package HOT100.验证二叉搜索树;

import java.util.Stack;

public class Solution {

    static class TreeNode{
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

    // 栈模拟中序遍历 当前值不大于前一个值，那么不是二叉搜素树
    public boolean isValidBST(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        long pre = Long.MIN_VALUE;
        while (root != null || !st.isEmpty()){
            while (root != null){
                st.push(root);
                root = root.left;
            }
            root = st.pop();
            if(root.val <= pre)
                return false;
            pre = root.val;
            root = root.right;
        }
        return true;
    }


    public static void main(String[] args) {

        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Solution sl = new Solution();
        sl.isValidBST(root);
    }

}
