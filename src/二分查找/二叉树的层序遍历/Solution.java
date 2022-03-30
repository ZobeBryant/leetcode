package 二分查找.二叉树的层序遍历;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val =val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Deque<TreeNode> q = new LinkedList<>();
        if(root == null)
            return new ArrayList<>();
        q.offer(root);
        // int cur = 1;
        List<List<Integer>> res = new ArrayList<>();
        while (!q.isEmpty()){
            List<Integer> list = new ArrayList<>();
            TreeNode node;
            int cur = q.size();
            // int temp = 0;
           for(int i = 0; i < cur; ++i){
                node = q.poll();
                list.add(node.val);
                if(node.left != null){
                    q.offer(node.left);
                }
                if(node.right != null){
                    q.offer(node.right);
                }
           }
           res.add(list);
        }
    return res;
    }
}
