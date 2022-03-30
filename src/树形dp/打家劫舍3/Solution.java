package 树形dp.打家劫舍3;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {

    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(){}
        TreeNode(int val){this.val = val;}
        TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
    // 错误 测试用例只过了一半
    public static int rob(TreeNode root) {
        if(root == null)
            return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int s1=0,s2=0;
        int count = 1, n ;
        boolean flag = true;
        while (!q.isEmpty()){
            n = count;
            count = 0;
            while (n-- > 0){

                TreeNode node = q.poll();

                if(flag){
                    s1 += node.val;
                }else {
                    s2 += node.val;
                }
                if(node.left != null){
                    ++count;
                    q.offer(node.left);
                }
                if(node.right != null){
                    ++count;
                    q.offer(node.right);
                }
            }
            flag = !flag;
        }
        return Math.max(s1, s2);
    }

    // 动态规划 当前节点偷dp[0] 当前节点不偷dp[1]
    public int rob2(TreeNode root) {
        int[] res = dfs(root);
        return Math.max(res[0], res[1]);
    }
    //树的后续遍历 + 搜索
    public int[] dfs(TreeNode root){
        if(root == null){
            return new int[]{0,0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[2];
        // 当前位置不偷 子节点偷不偷都行
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        // 当前位置偷 子节点都不能偷
        dp[1] = root.val + left[0] + right[0];
        return dp;
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        rob(root);
    }
}
