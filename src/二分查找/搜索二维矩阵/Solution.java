package 二分查找.搜索二维矩阵;

public class Solution {
    public boolean searchMatrix(int[][] matrix,int target){
        int m=matrix.length;
        if(m==0)
            return false;
        int n=matrix[0].length;
        int low=0,height=m*n-1;

        while(low<=height){

            int mid=(low+height)/2;
            if(matrix[mid/n][mid%n]==target)
                return true;
            else
                if(matrix[mid/n][mid%n]>target)
                    height=mid-1;
                else
                    low=mid+1;

        }
    return false;
    }

}
