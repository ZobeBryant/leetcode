package 网易实习.电动车;

public class Solution {
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] e = {1,2,3,4,5};
        int[] c = {3,4,5,1,2};
        System.out.println(sl.canComplete(e,c));

    }

    public int canComplete(int[] e, int[] c){
        int n = c.length;
        int pos = -1;
        for(int i = 0; i < n; ++i){
            if(c[i] > e[i])
                continue;

           pos = dfs(e, c, i,(i+1) % n,e[i] - c[i]);
           if(pos != 1)
               break;
        }
        return pos;
    }

    public int dfs( int[] e, int[] c, int start, int cur, int sum ){
        if(sum < 0 && e[cur] + sum < c[cur])
            return -1;
        if(start == cur)
            return start;
        int temp = cur;
        ++cur;
        return dfs(e,c,start,cur % c.length,sum + e[temp] - c[temp] );
    }
}
