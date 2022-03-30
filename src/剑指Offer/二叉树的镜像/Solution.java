package 剑指Offer.二叉树的镜像;

import java.util.Stack;

public class Solution {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    // 错误
    public TreeNode mirrorTree(TreeNode root) {
        TreeNode B = new TreeNode(0);
        recur(root, B);
        return B;
    }
    public void recur(TreeNode A , TreeNode B){
        if(A == null){
            B = null;
            return;
        }

        B.val = A.val;
        B.right = new TreeNode(0);
        B.left = new TreeNode(0);
        recur(A.left, B.right);
        recur(A.right, B.left);

    }
    //  从根节点开始，递归地对树进行遍历，从叶子节点先开始翻转。如果当前遍历到的节点root的左右两棵子树都已翻转，那么我们只需交换两棵子树的位置
    public TreeNode mirrorTree2(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = mirrorTree2(root.left);
        TreeNode right = mirrorTree2(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    // 辅助栈
    TreeNode mirrorTree3(TreeNode root){
        if(root == null)
            return null;
        Stack<TreeNode> st = new Stack<>();
        st.add(root);
        while (!st.isEmpty()){
            TreeNode node = st.pop();
            if(node.left != null)
                st.add(node.left);
            if(node.right != null){
                st.add(node.right);
            }
            TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode test = new TreeNode(1);
/*        test.left = new TreeNode(2);
        test.left = null;
        System.out.println(test.left);*/
        Solution sl = new Solution();
        sl.mirrorTree(test);
    }

}
