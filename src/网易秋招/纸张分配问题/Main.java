package 网易秋招.纸张分配问题;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int n = str.length;
        long[] nums = new long[n + 2];
        nums[0] = Integer.parseInt(str[n - 1]);
        nums[n + 1] = Integer.parseInt(str[0]);
        for(int i = 1; i <= n - 1; ++i){
            nums[i] = Integer.parseInt(str[i]);
        }
        long[] res = new long[n + 2];
        Arrays.fill(res, 1);
        for(int i = 1; i < n; ++i){
            if(nums[i] > nums[i - 1] && res[i] <= res[i - 1]){
                res[i] = res[i - 1] + 1;
            }
        }
        for(int j = n + 1; j >= 1; --j){
            if(nums[j - 1] > nums[j] && res[j - 1] <= res[j]){
                res[j - 1] = res[j] + 1;
            }
        }
        long count = 0;
        for(int i = 1; i <= n; ++i){
            count += res[i];
        }
        System.out.println(count);
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");
        int n = str.length;
        long[] nums = new long[n];
        for(int i = 0; i < n; ++i){
            nums[i] = Integer.parseInt(str[i]);
        }
        long[] res = new long[n];
        Arrays.fill(res, 1);
        for(int i = 1; i < 2 * n; ++i){
            if(nums[i % n] > nums[(i - 1) % n]){
                res[i % n] = res[(i - 1) % n] + 1;
            }
        }
        for(int j = 2 * n - 2; j >= 0; --j){
            if(nums[j % n] > nums[(j + 1) % n] && res[j % n] <= res[(j + 1) % n]){
                res[j % n] = res[(j + 1) % n] + 1;
            }
        }
        long count = 0;
        for(int i = 1; i <= n; ++i){
            count += res[i];
        }
        System.out.println(count);
    }
}
