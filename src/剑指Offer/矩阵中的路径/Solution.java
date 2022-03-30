package 剑指Offer.矩阵中的路径;

public class Solution {
    public boolean exist(char[][] board, String word) {
        boolean flag;
        int n=board.length;
        int m=board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int i=0;i<n;++i){
            for(int j=0;j<m;++j){
                flag=dfs(board,visited,word,0,i,j);
                if(flag)
                    return true;

            }
        }
        return false;
    }
    public boolean dfs(char[][] board, boolean[][] visited, String word,int index,int i,int j){
        int[][] directions =new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
        if(board[i][j]!=word.charAt(index)){
            return false;
        }
        if(index == word.length()-1){
            return true;
        }
        boolean res=false;

            visited[i][j]=true;
            for(int[] direction: directions){
                int new_i= i+direction[0], new_j=j+direction[1];
                if(new_i>=0&&new_i<board.length&&new_j>=0&&new_j<board[0].length&&visited[new_i][new_j]==false){
                    boolean flag;
                    flag=dfs(board,visited,word,index+1,new_i,new_j);
                    if(flag){
                        res=flag;
                        break;
                    }

                }
        }
            visited[i][j] =false;
        return res;
    }
}
