package DFS.求根到叶子节点数字之后;

public class Solution {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x){
            val=x;
        }

    }


    public int sumNumbers(TreeNode root){

        return dfs(root,0);

    }

    public int dfs(TreeNode root, int prevSum){
        if(root==null)
            return 0;
        int sum=10*prevSum+root.val;
        if(root.left==null && root.right==null){
            return sum;
        }else{
           return dfs(root.left,sum)+dfs(root.right,sum);
        }


    }

}
