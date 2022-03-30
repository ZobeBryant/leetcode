package 剑指Offer.剪绳子2;

public class Solution {
    // 动态规划做 越界
    public int cuttingRope(int n) {
        long[] dp = new long[n+1];
        for(int i=2;i<=n;++i){
            long curMax=0;
            for(int j=1;j<i;++j){
                curMax = Math.max(curMax,Math.max((i-j)* j ,(dp[j])*(i-j) % 1000000007));
            }
            dp[i] = curMax;
        }
        return (int)dp[n];
    }

    // 贪心求解
//    如果 n == 2，返回1，如果 n == 3，返回2，两个可以合并成n小于4的时候返回n - 1
//    如果 n == 4，返回4
//    如果 n > 4，分成尽可能多的长度为3的小段，每次循环长度n减去3，乘积res乘以3；最后返回时乘以小于等于4的最后一小段；每次乘法操作后记得取余就行
//            以上2和3可以合并
    public int cuttingRope2(int n) {
        if(n < 4){
            return n - 1;
        }
        long res = 1;
        while (n > 4){
            res = res * 3 % 1000000007;
            n -= 3;
        }
        return (int) (res * n %1000000007);
    }

}
