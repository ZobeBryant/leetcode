package 二分查找.二维.有序矩阵中第k小的元素;

public class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        int left = matrix[0][0];
        int right = matrix[n-1][n-1];
        while (left < right){
            int mid = left + (right - left) / 2;
            // 不确定当前mid是否在matrix中
            if(check(matrix, mid , n, k)){
                // 如果数量不少于k个，说明最终答案不大于mid
                right = mid;
            }else {
                // 如果数量少于k个，说明最终答案大于mid
                left = mid + 1;
            }
        }
        return left;
    }

    boolean check(int[][] matrix, int mid, int n, int k ){
        int i = n - 1;
        int j = 0;
        int num = 0;
        // 统计小于等于mid的个数
        while (i >= 0 && j < n){
            if(matrix[i][j] <= mid){
                num += i + 1;
                j++;
            }else{
                i--;
            }
        }
        return num >= k;
    }
}