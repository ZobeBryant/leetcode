package 华为提前批;

import java.util.Scanner;

// 路线规划
public class Solution {
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int start = sc.nextInt();
        int N = sc.nextInt();
        int[][] path = new int[M][M];
        boolean[]visited = new boolean[M];
        for(int i = 0; i < N; ++i){
            int from = sc.nextInt();
            int to = sc.nextInt();
            path[from][to] = path[to][from] = sc.nextInt();
        }
        dfs(start, path, visited, M, 0, 1);
        if(res == Integer.MAX_VALUE)
            System.out.println(-1);
        else
            System.out.println(res);

    }

    public static void dfs(int cur, int[][] path, boolean[] visited, int M, int sum, int count){
        if(count == M){
            res = Math.min(res, sum);
        }
        visited[cur] = true;
        for(int i = 0; i < M; ++ i){
            if( cur == i || path[cur][i] <= 0 || visited[i] )
                continue;
            dfs(i, path, visited, M, sum + path[cur][i], ++count);
        }
        visited[cur] = false;
    }
}
