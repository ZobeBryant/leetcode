package 动态规划.最小路径和;

import java.util.Arrays;

public class Solution {

    //使用滑动数组
    public int minPathSum(int[][] grid) {

        int m=grid.length;
        int n=grid[0].length;

        int[] f=new int[n];

        Arrays.fill(f,Integer.MAX_VALUE);
        f[0]=0;
        for(int i=0;i<m;++i){
            for(int j=0;j<n;++j){
                if(j-1>=0)
                    f[j]=Math.min(f[j],f[j-1])+grid[i][j];
                else
                    f[j]+=grid[i][j];
            }
        }
        return f[n-1];
    }
}
