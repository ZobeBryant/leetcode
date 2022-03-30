package 腾讯实习第一次笔试.牛牛买商品;

import java.util.Scanner;

public class Solution {
    private static int res;
    public static void dfs(int[] p,int n,int m ,int index,int sum){
        if(index==n){
            if(sum>res&&sum%m==0)
                res=sum;
            return;
        }
        //选中当前商品
        dfs(p,n,m,index+1,sum+p[index]);
        //不选当前商品
        dfs(p,n,m,index+1,sum);
    }

    public static void main(String[] args) {
        Solution sl =new Solution();
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        sc.nextLine();
        int sum=0;
        int flag=0;
        //int res=0;
        while (true){
            int n=sc.nextInt();
            int m=sc.nextInt();
            sc.nextLine();
            int[] p = new int[n];
            for(int i=0;i<n;++i){
                p[i]= sc.nextInt();
                sum+=p[i];
            }
            sl.dfs(p,n,m,0,0);
            System.out.println(sum-sl.res);
            flag++;
            if(flag==N)
                break;
        }

//        int[] p1=new int[]{3,6,9};
//        int[] p2=new int[]{9,6,3,15};
//        sl.dfs(p2,4,5,0,0);
//        System.out.println(sl.res);
    }
}
