package 网易实习前端.樱桃;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.val = val;
        }
    }

    public int test(TreeNode root){
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int res = 0;
        while (!q.isEmpty()){
            TreeNode n = q.poll();
            if(n.left != null ){
                q.offer(n.left);
            }
            if(n.right != null){
                q.offer(n.right);
            }
            res +=dfs(n);
        }
        return res;
    }
    public int dfs(TreeNode root){
        if(root.left !=null && root.right != null && root.left.left ==null && root.right.right ==null ){
            return 5;
        }else if(root.left !=null && root.right == null && root.left.left ==null ||root.left ==null && root.right != null && root.right.right ==null ){
            return 2;
        }else{
            return 0;
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = null;
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(7);
        root.right.left.right = new TreeNode(8);
        root.right.right.left = null;
        root.right.right.right = new TreeNode(9);
        Solution sl = new Solution();
        System.out.println(sl.test(root));
    }



}
