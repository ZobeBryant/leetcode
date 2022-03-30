package 京东秋招.中庸的数;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    static class Num{
        int flag;
        int val;
        boolean canBeBound;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Num[] nums = new Num[n];
        for (int i = 0; i < n; ++i){
            nums[i] = new Num();
            nums[i].val = sc.nextInt();
            nums[i].flag = sc.nextInt();
            nums[i].canBeBound = nums[i].flag == 1;
        }
        Arrays.sort(nums, ((o1, o2) -> {
            if(o1.val != o2.val){
                return Math.min(o1.val, o2.val) - Math.max(o1.val, o2.val);
            }
            return o2.flag - o1.flag;
        }));
        int i = 0;
        while (i < n && !nums[i].canBeBound){
            ++i;
        }
        int j = n - 1;
        while (j >= 0 && !nums[j].canBeBound){
            --j;
        }
        int res = i <= j ? j - i + 1 : 0;
        System.out.println(res);
    }
}
