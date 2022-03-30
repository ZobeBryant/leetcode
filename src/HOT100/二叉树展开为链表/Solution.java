package HOT100.二叉树展开为链表;

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
    // 寻找前驱节点
    public void flatten(TreeNode root) {
        TreeNode cur = root;
        while (cur != null){
            if(cur.left != null){
                TreeNode pre = cur.left;
                while (pre.right != null){
                    pre = pre.right;
                }
                pre.right = cur.right;
                cur.right = cur.left;
                cur.left = null;
            }
            cur = cur.right;
        }
    }
}
