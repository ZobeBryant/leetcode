package 网易秋招.两数和;

import 网易秋招.航海探险.Solution;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int m = sc.nextInt();
        String[] nums = s.split(" ");
        int n = nums.length;
        int[] arr = new int[n];
        int res = 0;
        for(int i = 0; i < n; ++i){
            arr[i] = Integer.parseInt(nums[i]);
        }
        for(int i = 0; i < n - 1; ++i){
            for(int j = i + 1; j < n; ++j ){
                if(arr[i] + arr[j] <= m){
                    ++res;
                }
            }
        }
        System.out.println(res);
    }
}
