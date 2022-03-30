package 百度秋招.像素;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] nums = new int[n][n];
        int[][] res = new int[n * k][n * k];
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < n; ++j){
                nums[i][j] = sc.nextInt();
            }
        }
        for(int i = 0; i < n * k; i += k){
            for(int l = 0; l < k; ++l){
                for(int j = 0; j < n * k; j += k){
                    for(int m = 0; m < k; ++m){
                        res[i + l][j + m] = nums[i / k][j / k];
                    }
                }
            }
        }

        for(int i = 0; i < n * k; ++i){
            for(int j = 0; j < n * k; ++j){
                System.out.print(res[i][j] + " ");
            }
            System.out.println();
        }
    }

}
