package 剑指Offer.二叉树中和位某一值的路径;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right =right;
        }
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        recur(root, res, target, 0, temp);

        return res;
    }

    private void recur(TreeNode root, List<List<Integer>> res, int target, int cur, List<Integer> temp) {
        if(root == null)
            return;
        cur += root.val;
        temp.add(root.val);
        if( root.left == null && root.right == null){
            if(cur == target){
                res.add(new ArrayList<>(temp));
            }
            temp.remove(temp.size() - 1);
            return;
        }
        recur(root.left,res,target, cur, temp);
        recur(root.right,res,target, cur, temp);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        sl.pathSum(root, 3);
    }

}
