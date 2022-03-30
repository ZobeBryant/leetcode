package HOT100.把二叉搜索树转换为累加树;

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
    private int tmp = 0;
    public TreeNode convertBST(TreeNode root) {
        recur(root);
        return root;
    }

    public int recur(TreeNode root){
        if(root == null && tmp == 0)
            return 0;
        else if(root == null){
            return tmp;
        }
        int right =  recur(root.right);
        root.val += right;
        tmp = root.val;
        int left = recur(root.left);
        return left;
    }
    private int res = 0;
    public TreeNode convertBST2(TreeNode root) {
        if(root != null){
            convertBST2(root.right);
            res += root.val;
            root.val = res;
            convertBST(root.left);
        }
        return root;
    }
}
