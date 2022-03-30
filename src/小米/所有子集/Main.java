package 小米.所有子集;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        int n = strs.length;
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i){
            nums[i] = Integer.parseInt(strs[i]);
        }
        // [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
        int[][] res = new int[][]{{}, {1}, {2}, {1, 2}, {3}, {1, 3}, {2, 3}, {1, 2, 3}};
        System.out.println(res);
    }


}
