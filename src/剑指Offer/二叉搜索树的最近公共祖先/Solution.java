package 剑指Offer.二叉搜索树的最近公共祖先;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }

    }
    // 根据二叉搜索树的性质可以很快的找到到某个节点的路径
    // 一次遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        while (true){
            if(p.val < root.val && q.val < root.val){
                root = root.left;
            }else if(p.val > root.val && q.val > root.val){
                root = root.right;
            }else{
                return root;
            }

        }
    }


}
