package 京东秋招.小花吃竹子;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
   /* private static int res = 0;
    private static boolean flag = false;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[]{a, b, c};
        Arrays.sort(arr);
        dfs(arr, n, 0, 0);
        System.out.println(res);
    }

    public static void dfs(int[] arr, int n, int count, int value){
        if(value == n){
            res = count;
            flag = true;
            return;
        }else if(value > n){
            return;
        }
        for(int i = 0; i < 3; ++i){
            if(!flag){
                count++;
                value += arr[i];
                dfs(arr,n,count, value);
                count--;
                value -= arr[i];
            }else {
                break;
            }
        }
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int[] arr = new int[]{a, b, c};
        int count = 0;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for(int i = 1; i <= 3; ++i){
            int v = arr[i - 1];
            for(int j = v; j <= n; ++j){
                    if(dp[j - v] != 0)
                        dp[j] = dp[j - v];
                if(j == n && dp[j] != 0){
                    count = dp[j];
                }
            }
            if(count != 0)
                break;

        }
        System.out.println(count - 1);
    }

}
