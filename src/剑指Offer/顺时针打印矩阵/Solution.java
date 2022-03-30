package 剑指Offer.顺时针打印矩阵;

public class Solution {

    public int[] spiralOrder(int[][] matrix) {
        int[][] directions = new int[][] {{0,1},{1,0},{0,-1},{-1,0}};
        int n = matrix.length;
        if(n == 0){
            return new int[0];
        }
        int m = matrix[0].length;
        int len = n * m;
        int i = 0, j = 0;
        boolean [][] visited = new boolean[n][m];
        int cur = 0;
        int[] res = new int[n * m];
        res[0] = matrix[0][0];
        int count = 0;
        while (len > 0){
            visited[i][j] = true;
            res[count] = matrix[i][j];
            int new_i = i + directions[cur][0], new_j = j +directions[cur][1];
            if(new_i >= n || new_i < 0 || new_j >= m || new_j < 0 || visited[new_i][new_j] == true ){
                cur = (cur + 1) % 4 ;
            }
            i += directions[cur][0];
            j += directions[cur][1];
            ++count;
            --len;

        }
        return res;
    }
}
