package HOT100.路径总和3;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public static class TreeNode{
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
    public int pathSum(TreeNode root, int targetSum) {
        if(root == null)
            return 0;
        backTrack(root, targetSum, 0);
        pathSum(root.left, targetSum);
        pathSum(root.right, targetSum);
        return count;
    }

    private int count = 0;
    // private Map<TreeNode, Boolean> map = new HashMap<>();
    public void backTrack(TreeNode root, int targetSum, int curSum){
        if(root == null)
            return;
        curSum += root.val;
        if(curSum == targetSum){
            count++;
        }
            // 接着上次路径
            backTrack(root.left, targetSum, curSum);
            backTrack(root.right, targetSum, curSum);
       /* // 新开辟路径
        backTrack(root.left, targetSum, 0);
        backTrack(root.right, targetSum, 0);*/

    }
    private Map<Integer, Integer> map; // key:前缀和 value:key的次数
    private int target;
    private int res;
    // 前缀和
    public int pathSum2(TreeNode root, int targetSum) {
        map = new HashMap<>();
        // 初始化 前缀和为0的只有一个
        map.put(0, 1);
        target = targetSum;
        recur(root, 0);
        return res;
    }
    public void recur(TreeNode root, int curSum){
        if(root == null)
            return ;
        curSum += root.val;
        res += map.getOrDefault(curSum - target, 0);

        map.put(curSum, map.getOrDefault(curSum, 0) + 1);
        recur(root.left, curSum);
        recur(root.right, curSum);
        // 只有子孙依赖到当前前缀和
        map.put(curSum, map.get(curSum) - 1 );

    }

    public static void main(String[] args) {
        /*TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.right = new TreeNode(-3);
        root.right.right = new TreeNode(11);*/
        /*TreeNode root = new TreeNode(-2);
        root.right = new TreeNode(-3);*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(-2);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = new TreeNode(-2);
        root.left.left.left = new TreeNode(-1);
        Solution sl = new Solution();
        sl.pathSum(root, 3);
    }
}
