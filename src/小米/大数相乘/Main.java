package 小米.大数相乘;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] strs = str.split(" ");
        String res = multiply(strs[0], strs[1]);
        System.out.println(res);
    }
    public static String multiply(String n1, String n2){
        if(n1.equals("0") || n2.equals("0")){
            return "0";
        }
        int m = n1.length();
        int n = n2.length();
        int[] tmp = new int[m + n];
        for (int i = m - 1; i >= 0; --i){
            int x = n1.charAt(i) - '0';
            for(int j = n - 1; j >= 0; --j){
                int y = n2.charAt(j) - '0';
                tmp[i + j + 1] += x * y;
            }
        }
        for(int i = m + n - 1; i > 0; --i){
            tmp[i - 1] += tmp[i] / 10;
            tmp[i] %= 10;
        }
        int t = tmp[0] == 0 ? 1 : 0;
        StringBuilder res = new StringBuilder();
        while (t < m + n){
            res.append(tmp[t]);
            ++t;
        }
        return res.toString();
    }
}
