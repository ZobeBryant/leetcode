package 美图.小美的序列检查;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0){
            int n = sc.nextInt();
            int[] nums = new int[n];
            for(int i = 0; i < n; ++i){
                nums[i] = sc.nextInt();
            }
            String res = solve(nums, n);
            System.out.println(res);
        }
    }

    private static String solve(int[] nums, int n) {
        int[] counts = new int[n];
        for(int num:nums){
            if(num == 0 || num > n || ++counts[num - 1] > 1){
                return "No";
            }
        }
        return "Yes";
    }
}
