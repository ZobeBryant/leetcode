package 剑指Offer.二叉搜索树的后续遍历序列;

public class Solution {
    // 递归写法
    public boolean verifyPostorder(int[] postorder) {
        return recur(0,postorder.length-1,postorder);
    }
    public boolean recur(int i, int j, int[] postorder){
        if(i >= j)
            return true;
        int p=i;
        while (postorder[p] < postorder[j]) ++p;
        int m = p;
        while (postorder[p] > postorder[j]) ++p;
        return p == j && recur(i,m-1,postorder) && recur(m,j-1,postorder);
    }
}
