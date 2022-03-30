package HOT100.单词搜索;

public class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0; i < m; ++i){
            for(int j = 0; j < n; ++j){{
                if(!res){
                    backtrack(board, visited, word, i, j, 0);
                }

            }}
        }
        return res;

    }
    private boolean res = false;
    public void backtrack(char[][] board, boolean[][] visited, String word, int i, int j, int curLen){
        if(curLen == word.length() - 1){
            if(board[i][j] == word.charAt(curLen)){
                res = true;
            }
            return;
        }

        int[][] directions = new int[][]{{0, 1}, {1,0}, {-1, 0}, {0, -1}};
        visited[i][j] = true;
        for(int d[]: directions){
            if(board[i][j] == word.charAt(curLen) && i + d[0] < board.length && i + d[0] >= 0 &&  j + d[1] < board[0].length && j + d[1] >= 0 && !visited[i + d[0]][j + d[1]]){
                backtrack(board, visited, word, i + d[0], j + d[1], curLen + 1);
            }
        }
        visited[i][j] = false;
    }
}
