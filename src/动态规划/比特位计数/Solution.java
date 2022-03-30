package 动态规划.比特位计数;

public class Solution {

    //位1的个数妙用
    public int[] countBits(int num){
        int[] ans=new int[num+1];
        for(int i=0;i<=num;++i){
            ans[i]=popcount(i);
        }
        return ans;
    }

    private int popcount(int n){
        int count;
        for(count=0;n!=0;++count){
            n&=n-1;
        }
        return count;
    }

    //动态规划+最高有效位 状态转移方程 p(x+b)=p(x)+1 b=2^m > x
    public int[] countBits2(int num){
        int[] ans=new int[num+1];
        int i=0,b=1;
        while (b<=num){
            while (i<b && i+b<=num){
                ans[i+b]=ans[i]+1;
                ++i;
            }
            i=0;
            b<<=1;
        }
        return ans;
    }


    //动态规划+最低位有效位 状态转移方程 p(x)=p(x/2)+(x mod 2)
    public int[] countBits3(int num){
        int[] ans= new int[num+1];
        for(int i=1;i<=num;++i)
            ans[i]=ans[i>>1]+(i&1);
        return ans;
    }

    //动态规划+最后设置位 状态转移方程 p(x)=p(x&(x-1))+1
    public int[] countBits4(int num){
        int[] ans=new int[num+1];
        for(int i=1;i<=num;++i){
            ans[i]=ans[i&(i-1)]+1;
        }
        return ans;
    }



}
