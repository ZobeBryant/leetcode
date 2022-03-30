package 剑指Offer.从上到下打印二叉树3;

import java.util.*;

public class Solution {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean flag = true;
        while (!q.isEmpty()){
            List<Integer> levelOrder = new ArrayList<>();
            int size = q.size();
            for(int i = 0; i < size; ++i){
                TreeNode p = q.poll();
                if(p.left != null)
                    q.offer(p.left);
                if(p.right != null)
                    q.offer(p.right);
                levelOrder.add(p.val);
            }
            if(!flag){
                Collections.reverse(levelOrder);
            }
            flag = !flag;
            res.add(levelOrder);
        }
        return res;
    }
}
