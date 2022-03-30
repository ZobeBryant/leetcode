package 剑指Offer.重建二叉树;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<inorder.length;++i){
            map.put(inorder[i],i);
        }

       return tree(preorder,inorder,0,preorder.length-1,0,inorder.length-1,map);
    }

    public TreeNode tree(int[] preorder, int[] inorder, int preorder_left, int preorder_right,int inorder_left, int inorder_right,Map indexMap){
        if(preorder_left > preorder_right){
           return  null;
        }

        // 获取前序遍历元素在中序遍历序列中的位置
        int preorder_root = preorder_left;
        int inorder_root = (int) indexMap.get(preorder[preorder_root]);

        //创建当前根节点
        TreeNode root = new TreeNode(preorder[preorder_root]);
        int leftSubTree = inorder_root - inorder_left;

        root.left = tree(preorder,inorder,preorder_left+1,preorder_left+leftSubTree,inorder_left,inorder_root-1,indexMap);
        root.right = tree(preorder,inorder,preorder_left+leftSubTree+1,preorder_right,inorder_root+1,inorder_right,indexMap);

        return root;
    }
}
