package 动态规划.零钱兑换;

import java.util.Arrays;

public class Solution {

    //动态规划 自下而上  f[i]=min(j=0..n-1)f(i-cj)+1

    public int coinChange(int[] coins, int amount){

        int[] f=new int[amount+1];
        Arrays.fill(f,Integer.MAX_VALUE);

        f[0]=0;

        for(int i=1;i<=amount;++i){
            for(int j=0;j<coins.length;++j){
                if(coins[j]<=i){
                    f[i]=Math.min(f[i],f[i-coins[j]]+1);
                }
            }
        }
        return f[amount] > amount ? -1: f[amount];

    }

    public static void main(String[] args) {
        int a=Integer.MAX_VALUE;
        System.out.println(a);
    }

}
