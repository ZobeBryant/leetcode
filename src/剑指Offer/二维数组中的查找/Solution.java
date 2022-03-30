package 剑指Offer.二维数组中的查找;

public class Solution {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0){
            return false;
        }
        int row = 0, col = matrix[0].length-1;
        while(row < matrix.length && col >=0){
            int num = matrix[row][col];
            if(num == target){
                return true;
            }else if(num < target){
                ++row;
            }else {
                --col;
            }
        }
        return false;
    }
}
