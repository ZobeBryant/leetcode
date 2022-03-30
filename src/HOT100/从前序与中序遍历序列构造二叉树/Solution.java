package HOT100.从前序与中序遍历序列构造二叉树;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    class TreeNode{
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
    private Map<Integer, Integer> map = new HashMap<>();
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0; i < preorder.length; ++i){
            map.put(inorder[i], i);
        }
        return build(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int preorderLeft, int preorderRight, int inorderLeft, int inorderRight){
        if(preorderLeft > preorderRight)
            return null;

        TreeNode root = new TreeNode(preorder[preorderLeft]);
        // 左子树的节点数
        int curInorderIndex = map.get(preorder[preorderLeft]);
        int count =  curInorderIndex - inorderLeft;
        root.left = build(preorder, inorder, preorderLeft + 1, preorderLeft + count, inorderLeft, curInorderIndex - 1);
        root.right = build(preorder, inorder, preorderLeft + count + 1, preorderRight, curInorderIndex + 1, inorderRight);
        return root;
    }

}
