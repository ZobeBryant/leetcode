package 剑指Offer.机器人的运动范围;

import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    // 深度优先遍历
    public int movingCount(int m, int n, int k) {
        int count;
        boolean[][] visited = new boolean[m][n];
        count=dfs(0,0,m,n,k,visited);
        return count;
    }
    public int dfs(int i,int j, int m, int n, int k,boolean[][] visited){
        if(i >=m||j>=n||sum(i)+sum(j)>k||visited[i][j]){
            return 0;
        }
        visited[i][j] = true;
        return 1+dfs(i+1,j,m,n,k,visited)+dfs(i,j+1,m,n,k,visited);
    }
    public int sum(int i){
        int sum=0;
        while (i !=0){
            sum+=i%10;
            i/=10;
        }
        return sum;
    }

    // 广度优先遍历
    public int movingCount2(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        Deque<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{0,0});
        int[][] directions=new int[][]{{0,1},{1,0}};
        visited[0][0]=true;
        int ans = 1;
        while (!queue.isEmpty()){
            int[] q=queue.poll();
            for(int []direction:directions){
                int new_i=q[0]+direction[0],new_j=q[1]+direction[1];
                if(new_i>=m||new_j>=n||sum(new_i)+sum(new_j)>k||visited[new_i][new_j]){
                    continue;
                }
                queue.offer(new int[]{new_i,new_j});
                visited[new_i][new_j]=true;
                ans+=1;
            }
        }
        return ans;
    }
}
