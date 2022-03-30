package 剑指Offer.从上到下打印二叉树2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null)
            return result;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()){
            List<Integer> levelOrder = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; ++i){
                TreeNode p = q.poll();
                if(p.left != null){
                    q.offer(p.left);
                }
                if(p.right != null){
                    q.offer(p.right);
                }

                levelOrder.add(p.val);
            }
            result.add(levelOrder);
        }
        return result;
    }
}
