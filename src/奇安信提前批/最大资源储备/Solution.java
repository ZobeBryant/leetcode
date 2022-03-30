package 奇安信提前批.最大资源储备;

public class Solution {
    public int getMaximumResource (int[][] grid) {
        // write code here
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){
                visited[i][j] = true;
                dfs(grid,visited, grid[i][j], i, j);
                visited[i][j] = false;
            }
        }
        return res;
    }
    private int res = 0;
    public void dfs(int[][] grid, boolean[][] visited, int curSum, int i, int j){
        if(grid[i][j] == 0){
            res = Math.max(res, curSum);
            return;
        }
        // 上下左右
        int[][] directions = new int[][]{{-1, 0},{1, 0}, {0, -1}, {0, 1}};
        for(int[] d : directions){
            if(i + d[0] < grid.length && i + d[0] >= 0 && j + d[1] < grid[0].length && j + d[1] >= 0 && !visited[i + d[0]][j + d[1]] ){
                visited[i + d[0]][j + d[1]] = true;
                curSum += grid[i + d[0]][j + d[1]];
                dfs(grid, visited, curSum, i + d[0], j + d[1]);
                visited[i + d[0]][j + d[1]] = false;
                curSum -= grid[i + d[0]][j + d[1]];
            }
        }

    }

    public static void main(String[] args) {
       //  [[0,6,0],[5,8,7],[0,9,0]]
        // [[1,0,7],[2,0,6],[3,4,5],[0,3,0],[9,0,20]]
        Solution sl = new Solution();
        int[][] grid = new int[][]{{1, 0, 7}, {2, 0, 6},{3, 4, 5}, {0, 3, 0},{9, 0, 20}};
        sl.getMaximumResource(grid);
    }
}

