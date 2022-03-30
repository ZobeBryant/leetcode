package 树形dp.监控二叉树;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }


    public int minCameraCover(TreeNode root) {
        int[] res = minCam(root);
        return Math.min(res[0], res[2]);
    }
    public int[] minCam(TreeNode root){
        if(root == null){
            return new int[]{Integer.MAX_VALUE / 2, 0 ,0};
        }
        int[] left = minCam(root.left); //左子树的minCam
        int[] right = minCam(root.right); //右子树的minCam
        int withCam = 1 + Math.min(left[1] + right[1],Math.min(left[0] + right[1], left[1] + right[0]));

        int noCamWatchByDad = Math.min(left[0] + right[0],Math.min(left[0] + right[2], Math.min(left[2] + right[0], left[2] + right[2])));

        int noCamWatchBySon = Math.min(left[0] + right[0],Math.min(left[0] + right[2], left[2] + right[0]));

        return new int[]{withCam, noCamWatchByDad, noCamWatchBySon};
    }
}
