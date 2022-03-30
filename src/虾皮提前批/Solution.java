package 虾皮提前批;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    Double deploy(int[] failed, int[] total, int[][] dependencies ){
        int n = failed.length;
        double[] p = new double[n];
        for(int i = 0; i < n; ++i){
            p[i] = 1.0 * (total[i] - failed[i]) / 10;
        }
        List<Integer> up = new ArrayList<>();
        List<Integer> down = new ArrayList<>();
        boolean[] visited = new boolean[n];
        // 找出最下游的项目
        for(int i = 0; i < n; ++ i){
            for(int j = 0; j < dependencies[i].length; ++j){
                int index = dependencies[i][j];
                if(!visited[index]){
                    visited[index] = true;
                }
            }
            if(dependencies[i].length == 0){
                up.add(i);
            }
        }
        // 找出上游
        for(int i = 0; i < n; ++i){
            if(!visited[i]){
                down.add(i);
            }
        }
        double resFin = Double.MIN_VALUE;
        for(int i = 0; i < up.size(); ++i){
            double res = 1.0;
            for(int j = 0; j < down.size(); ++j){
                res *= dfs(dependencies, up.get(i),p, up, down.get(j));
            }
            resFin = Math.max(res, resFin);
        }

        return resFin;
    }

    public double dfs(int[][] dependencies, int upIndex, double[] p, List<Integer> up , int curIndex ){
        if(up.contains(curIndex)){
            if(curIndex == upIndex){
                return 1.0;
            }else{
                return p[curIndex];
            }
        }
        double curRes = p[curIndex];
        for(int i = 0; i < dependencies[curIndex].length; ++i){
            curRes *= dfs(dependencies, upIndex, p, up, dependencies[curIndex][i]);
        }
        return curRes;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] failed = {1, 1, 1, 1, 1}, total = {10, 10, 10, 10, 10};
        int[][] dependencies = {{},{0},{0},{1, 2}, {3}};
        double res = sl.deploy(failed,total, dependencies);
        System.out.println(res);
    }
}
