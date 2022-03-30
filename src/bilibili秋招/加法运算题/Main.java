package bilibili秋招.加法运算题;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int res = 0;
        for(int i = 0; i <= n; ++i){
            if(i % 2 == 1)
                res += i;
        }
        System.out.println(res);
    }
}
