package 剑指Offer.二叉搜索树的第k大节点;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    private List<Integer> list = new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        inorder(root);
        return list.get(list.size() - k);
    }

    public void inorder(TreeNode root){
        if(root == null)
            return;
        inorder(root.left);
        list.add(root.val);
        inorder(root.right);
    }
    private int res, k;
    public int kthLargest2(TreeNode root, int k) {
        this.k = k;
        inorder2(root);
        return res;
    }

    private void inorder2(TreeNode root) {
        if(root == null)
            return;
        inorder2(root.right);
        if(--k == 0) res = root.val;
        inorder2(root.left);
    }

}
