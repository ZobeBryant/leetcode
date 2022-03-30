package HOT100.旋转图像;

public class Solution {
    public void rotate(int[][] matrix) {
        // 关于对角线对称的元素互换
        for(int i = 0; i < matrix.length; ++i){
            for(int j = i + 1; j < matrix[0].length; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        // 垂直线上的元素互换
        for(int i = 0; i < matrix.length; ++i){
            for(int j = 0; j < matrix[0].length / 2; ++j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][matrix[0].length - 1 - j];
                matrix[i][matrix[0].length - 1 - j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        Solution sl = new Solution();
        sl.rotate(matrix);
    }
}
