package 剑指Offer.青蛙跳台阶问题;

public class Solution {
    // 递归 超时
    public int numWays(int n) {
        if(n == 0){
            return 1;
        }else if(n==1){
            return 1;
        }
        return numWays(n-1)+numWays(n-2);

    }
    public int numWays1(int n) {
        int a = 1, b = 1;
        for(int i = 1; i <=n;++i){
            int temp = (a+b)%1000000007;
            a=b;
            b=temp;
        }
        if(n == 0){
            return 1;
        }else{
            return  a;
        }

    }
}
