package 剑指Offer.树的子结构;


import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val = x;
        }
    }
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B==null){
            return false;
        }
        Boolean flag = false;
        Queue<TreeNode> q1 = new LinkedList<>();
        Queue<TreeNode> q2 = new LinkedList<>();
        q1.offer(A);
        while (!q1.isEmpty()){
            TreeNode node = q1.poll();
            if(node.val == B.val){
                q2.offer(node);
            }
            if(node.left != null)
                q1.offer(node.left);
            if(node.right !=null)
                q1.offer(node.right);
        }
        while (!q2.isEmpty()){
            TreeNode node = q2.poll();
            flag = dfs(node,B);
            if(flag == true)
                break;
        }
        return flag;
    }

    //判断树A与树B是否相同
    public boolean dfs(TreeNode A, TreeNode B){
            if(B == null) return true;
            if(A == null || A.val != B.val) return false;
            return dfs(A.left, B.left) && dfs(A.right, B.right);

    }
    // 改进
    public boolean isSubStructure2(TreeNode A, TreeNode B) {
        if(B==null){
            return false;
        }
        Boolean flag = false;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(A);
        while (!q1.isEmpty()){
            TreeNode node = q1.poll();
            if(node.val == B.val){
                flag = dfs(node,B);
                if(flag == true)
                    break;
            }
            if(node.left != null)
                q1.offer(node.left);
            if(node.right !=null)
                q1.offer(node.right);
        }
        return flag;
    }


    public static void main(String[] args) {
        Solution sl = new Solution();
        TreeNode A = new TreeNode(1);
        A.left = new TreeNode(2);
        A.right = new TreeNode(3);
        A.left.left = new TreeNode(4);
        TreeNode B = new TreeNode(3);
        sl.isSubStructure(A,B);
    }

}
