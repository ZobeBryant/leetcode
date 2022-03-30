package 剑指Offer.从上到下打印二叉树;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if(root == null)
            return new int[0];
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        List<Integer> list = new ArrayList<>();
        while (!q.isEmpty()){
            TreeNode p = q.poll();
            list.add(p.val);
            if(p.left != null)
                q.offer(p.left);
            if(p.right != null)
                q.offer(p.right);
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); ++i){
            res[i] = list.get(i);
        }
        return res;
    }
}
