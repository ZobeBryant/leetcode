package DFS.将有序数组转换为二叉搜索树;

public class Solution {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }
    }

    public TreeNode sortedArrayToBST(int[] nums){
        return helper(nums,0,nums.length-1);
    }
    public TreeNode helper(int nums[], int left, int right){
        if(left>right)
            return null;

        int mid=(left+right)/2;

        TreeNode root=new TreeNode(nums[mid]);
        root.left=helper(nums,left,mid-1);
        root.right=helper(nums,mid+1,right);
        return root;

    }

}
