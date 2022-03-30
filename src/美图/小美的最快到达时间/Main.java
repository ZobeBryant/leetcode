package 美图.小美的最快到达时间;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int start = sc.nextInt() - 1;
        int end = sc.nextInt() - 1;
        int[][] bus = new int[n][n];
        int[] waitTime = new int[n];
        int[][] walk = new int[n][n];
        for(int i = 0; i < m; ++i){
            int x = sc.nextInt() - 1;
            int y = sc.nextInt() - 1;
            bus[x][y] = sc.nextInt();
            walk[x][y] = sc.nextInt();
        }
        for(int i = 0; i < n; ++i){
            waitTime[i] = sc.nextInt();
        }
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                if(i == j)
                    continue;
                if(walk[i][j] == 0){
                    walk[i][j] = INF;
                }
                if(bus[i][j] == 0){
                    bus[i][j] = INF;
                }
            }
        }
        int res = solve(start, end, bus, waitTime, walk, n);
        System.out.println(res);
    }
    static final int INF = Integer.MAX_VALUE / 2;
    private static int solve(int start, int end, int[][] bus, int[] waitBusTime, int[][] walk, int n) {
        int[] walkTime = getWalkTime(start, walk, n);
        int res = INF;
        for(int i = 0; i < n; ++i){
            if(walkTime[i] != INF){
                int time = Math.max(waitBusTime[i] - walkTime[i], walkTime[i] + bus[i][end]);
                res = Math.min(res, time);
            }
        }
        return res;
    }

    private static int[] getWalkTime(int start, int[][] walk, int n) {
        int[] walkTime = new int[n];
        System.arraycopy(walk[start], 0, walkTime, 0, n);
        boolean[] visited = new boolean[n];
        visited[start] = true;
        for(int i = 1; i<n;++i){
            int next = -1;
            int time = INF;
            for(int j = 0; j < n; ++j){
                if(!visited[j] && walkTime[j] < time){
                    next = j;
                    time = walkTime[j];
                }
            }
            visited[next] =true;
            for(int j = 0; j < n; ++j){
                if(visited[j] || walk[next][j] == INF){
                    continue;
                }
                int nextTime = time + walk[next][j];
                walkTime[j] = Math.min(walkTime[j], nextTime);
            }
        }
        return walkTime;
    }



}
