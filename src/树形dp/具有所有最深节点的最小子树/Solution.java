package 树形dp.具有所有最深节点的最小子树;

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
//    public TreeNode subtreeWithAllDeepest(TreeNode root) {
//
//    }
}
