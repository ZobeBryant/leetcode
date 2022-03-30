package 携程提前批.阶梯石子;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i){
            nums[i] = sc.nextInt();
        }
        /*int count = 0;
        for(int i = 0; i < n; ++i){
            count += Math.abs(nums[i] - i - 1);
        }
        for(int i = 0; i < n; ++i){
            *//*if(i != n-1){
                if(count <= 0){
                    System.out.print(count);
                }
                else {
                    System.out.print(count);
                    count -= 2;
                }
                System.out.print(" ");
            }else{
                System.out.print(count);
            }*//*
            System.out.println(Math.max(count - 2 * i, 0) + " ");
        }*/

        int[] dp = new int[n];
        dp[0] = nums[0] - 1;
        int count = dp[0];
        for(int i = 1; i < n; ++i){
            dp[i] = dp[i - 1] + nums[i] - i - 1;
            count += dp[i];
        }
        Arrays.sort(dp);
        for(int i = n; i > 0; --i){
            if( i == n){
                System.out.print(count);
                System.out.print(" ");
            }else{
                count -= dp[i];
                System.out.print(count);
                System.out.print(" ");
            }

        }
    }

}
