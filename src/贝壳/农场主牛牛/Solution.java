package 贝壳.农场主牛牛;

import java.util.Arrays;

public class Solution {
    /*public long[] FarmerNN (int n, long m) {
        // write code here
        long[] res = new long[n];
        int i = 0;
        int dir = 1;
        while (m-- > 0){
            res[i] += 1;
            i += dir;
            if(i == n){
                i -=  2;
                dir = -1;
            }
            if(i == -1){
                i += 2;
                dir = 1;
            }
        }
        return res;
    }
*/
    public long[] FarmerNN (int n, long m) {
        long[] res = new long[n];
        Arrays.fill(res, 1);
        m -= n;
        int batch = n - 1;
        long count = m / batch;
        res[0] += (count + 1) / 2;
        res[n - 1] += count / 2;
        for(int i = 1; i < n - 1; ++i){
            res[i] += count;
        }
        long rest = m  % batch;
        if(count % 2 == 0){
            for(int i = n - 2; i >= n - 1 - rest; --i){
                res[i]++;
            }
        }else{
            for(int i = 1; i < rest; ++i){
                res[i]++;
            }
        }
        return res;
    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.FarmerNN(4, 6);
    }
}
