package 二分查找.完全二叉树的节点个数;



public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    public int countNodes(TreeNode root){
        if(root!=null)
            return 0;
        return countNodes(root.left)+countNodes(root.right)+1;

    }

}
