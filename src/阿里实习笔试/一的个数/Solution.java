package 阿里实习笔试.一的个数;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N=sc.nextInt();
        int flag = 0;
        while (true){
            StringBuilder sb = new StringBuilder();
            StringBuilder temp;
            int res = 0;
            int n = sc.nextInt();
            for(int i = 0; i < n; ++i){
                int num = sc.nextInt();
                if(num == 0)
                    flag = 1;
                sb.append(num);
            }
            if(flag == 0){
                System.out.println(n-1);
            }else{
                for(int i = 0;i < n; ++i){
                    temp = new StringBuilder(sb.toString());
                    if(temp.charAt(i) == '0'){
                        temp.deleteCharAt(i);
                        String[] ones = temp.toString().split("0");
                        for(String one : ones){
                            res = Math.max(res,one.length());
                        }
                    }
                }
                System.out.println(res);
            }
            N--;
            if(N==0)
                break;

        }
    }
    // 动态规划方法
    public int ans(int[] nums, int n){
        // dp表示以i为终点最长序列（连续1）的长度
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];
        dp1[0]=nums[0];
        dp2[n-1]=nums[n-1];
        for(int i=1;i<n;++i){
            if(nums[i]==1){
                dp1[i]=dp1[i-1]+1;
            }else {
                dp1[i]=0;
            }
            if(nums[n-i]==1){
                dp2[n-i-1]=dp2[n-i]+1;
            }else {
                dp2[n-i-1]=0;
            }
        }
        int max = Math.max(dp1[n-2],dp2[1]);
        for(int i = 1; i < n-1;++i){
            max = Math.max(max,Math.max(dp1[i-1],dp2[i+1]));
        }
        return max;
    }

}
