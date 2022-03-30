package 剑指Offer.圆圈中最后剩下的数字;

public class Solution {
    // 超时
    public int lastRemaining(int n, int m) {
        int[] num = new int[n];
        for(int i = 0; i < n; ++i){
            num[i] = i;
        }
        int pos = 0;
        int c1 = n;
        int c2 ;
        while (c1 > 1){
            if(c1 == n){
                num[(m-1) % n] = -1;
                pos = m;
            }else{
                c2 = m;
                while (c2 > 0){
                    if(num[pos % n] != -1){
                        c2--;
                    }
                    if(c2 != 0)
                        pos = ( pos + 1) % n;
                }
                num[pos % n] = -1;
                pos = ( pos + 1) % n;
            }
            c1--;
        }

        for(int i = 0; i < n; ++i){
            if(num[i] != -1)
                return i;
        }

        return 0;
    }
    // f(n,m)返回剩下数字的坐标 假设f(n-1, m)返回的坐标是x 那么f(n,m)的结果为(m%n+x)%n 即(m+n)%n
    // 发现了递归的性质
    // 递推解这道题
    public int lastRemaining2(int n, int m) {
        int res = 0;
        for(int i = 2; i <= n; ++i){
            res = ( m + res) % i;
        }
        return res;
    }

    public static void main(String[] args) {

        Solution sl = new Solution();
        sl.lastRemaining(5,3);
    }
}
