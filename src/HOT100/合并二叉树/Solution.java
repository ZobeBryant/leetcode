package HOT100.合并二叉树;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 写的比较麻烦（新建的树是完全新的）
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        TreeNode root = new TreeNode();
        recur(root1, root2, root);
        return root;
    }
    public void recur(TreeNode root1, TreeNode root2, TreeNode root){
        if(root1 == null)
            root.val = root2.val;
        else if(root2 == null)
            root.val = root1.val;
        else
            root.val = root1.val + root2.val;
        if(root1 != null && root2 != null && ( root1.left != null || root2.left !=null)){
            TreeNode node = new TreeNode();
            root.left = node;
            recur(root1.left, root2.left, node);
        }else if(root1 != null && root1.left != null){
            TreeNode node = new TreeNode();
            root.left = node;
            recur(root1.left, null, node);
        }else if(root2 != null && root2.left != null){
            TreeNode node = new TreeNode();
            root.left = node;
            recur(null, root2.left, node);
        }

        if(root1 != null && root2 != null && (root1.right != null || root2.right !=null)){
            TreeNode node = new TreeNode();
            root.right = node;
            recur(root1.right, root2.right, node);
        }else if(root1 != null && root1.right != null){
            TreeNode node = new TreeNode();
            root.right = node;
            recur(root1.right, null, node);
        }else if(root2 != null && root2.right != null){
            TreeNode node = new TreeNode();
            root.right = node;
            recur(null, root2.right, node);
        }
    }

    // 新建的树是部分新的
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if(root1 == null)
            return root2;
        if(root2 == null)
            return root1;
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees2(root1.left, root2.left);
        root.right = mergeTrees2(root1.right, root2.right);
        return root;
    }

}
