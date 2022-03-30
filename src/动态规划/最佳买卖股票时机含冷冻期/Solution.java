package 动态规划.最佳买卖股票时机含冷冻期;

public class Solution {

    //f[i][0]手上持有股票的最大收益  f[i][1]手上不持有股票，并且处于冷冻期中的累计最大收益 f[i][2]手上不持有股票，并且不再冷冻期中的累计最大收益
    public int maxProfit(int[] prices) {
        if(prices.length==0)
            return 0;

        int n=prices.length;
        int[][] f=new int[n][3];

        f[0][0]=-prices[0];
        for(int i=1;i<n;++i){
            f[i][0]=Math.max(f[i-1][0],f[i-1][2]-prices[i]);
            f[i][1]=f[i-1][0]+prices[i];
            f[i][2]=Math.max(f[i-1][1],f[i-1][2]);
        }

        return Math.max(f[n-1][1],f[n-1][2]);
    }

   //注意到上面的状态转移方程中，f[i][..]f[i][..] 只与 f[i-1][..]f[i−1][..] 有关，而与 f[i-2][..]f[i−2][..] 及之前的所有状态都无关，
    // 因此我们不必存储这些无关的状态。也就是说，我们只需要将 f[i-1][0]f[i−1][0]，f[i-1][1]f[i−1][1]，f[i-1][2]f[i−1][2] 存放在三个变量中，
    // 通过它们计算出 f[i][0]f[i][0]，f[i][1]f[i][1]，f[i][2]f[i][2] 并存回对应的变量，以便于第 i+1i+1 天的状态转移即可。
   public int maxProfit2(int[] prices) {
       if(prices.length==0)
           return 0;

       int n=prices.length;
       int f0=-prices[0];
       int f1=0;
       int f2=0;

       for(int i=1;i<n;++i){
           int new0=Math.max(f0,f2-prices[i]);
           int new1=f0+prices[i];
           int new2=Math.max(f1,f2);
           f0=new0;
           f1=new1;
           f2=new2;
       }
       return Math.max(f1,f2);
   }

}
