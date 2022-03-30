package 美图.回文串;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
   /* *//*public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       String s = sc.nextLine();
       StringBuilder sb = new StringBuilder();
       sb.append(s);
       if(judge(s)){
           System.out.println(0);
       }
       for(int i = 0; i < s.length(); ++i){
           String tmp =  new StringBuilder(s.substring(0, i + 1)).reverse().toString();
           sb.append(tmp);
           if(judge(sb.toString())){
               System.out.println(i + 1);
               break;
           }
           sb.delete(sb.length() - i - 1,sb.length());
       }
   }

    public static boolean judge(String s){
        int n = s.length();
        for(int i = 0; i < n; ++i){
            if(s.charAt(i) != s.charAt(n - i - 1)){
                return false;
            }
        }
        return true;
    }*/

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        int res = s.length() - longestPalindrome(s);
        System.out.println(res);
    }

    private static int longestPalindrome(String s) {
        char[] str = s.toCharArray();
        int len = str.length;
        boolean[][] dp = new boolean[len][len];
        dp[0][0] = true;
        int maxLen = 1;
        for(int j = 1; j < len; ++j){
            for(int i = 0; i <= j; ++i){
                if(str[i] == str[j]){
                    if(j - i <= 2){
                        dp[i][j] = true;
                    }else {
                        dp[i][j] = dp[i +1][j - 1];
                    }
                }
                if(dp[i][j] && j - i + 1 > maxLen){
                    maxLen = j - i + 1;
                }
            }
        }
        return maxLen;
    }
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int N = 1000;
        Info[] a = new Info[N];
        for(int i = 0; i < n; ++i){
            int pos = sc.nextInt();
            String dir = sc.next();
            a[i].x = pos;
            a[i].id = i;
            a[i].dir = "L".equals(dir)  ? - 1: 1;

        }
        Arrays.sort(a);
        int[] ans = new int[N];
        boolean[] vis = new boolean[N];
        Arrays.fill(ans, -1);
        for(int i = 0; i < n; ++i){
            if(vis[a[i].id]){
                continue;
            }
            if(a[i].dir == 1){
                for(int j = i + 1; j < n; ++j){
                    if(vis[a[j].id]){
                        continue;
                    }
                    if(a[j].dir == 1 && (a[j].x - a[i].x) % 2 ==0){
                        break;
                    }
                    int dx = a[j].x - a[i].x;
                    if((dx & 1) > 0 ){
                        continue;
                    }
                    ans[a[i].id] = dx /2;
                    vis[a[i].id] = true;
                    ans[a[j].id ] = dx / 2;
                    vis[a[j].id ] = true;
                    break;
                }
            }
        }
        for(int i = 0; i < n; ++i){
            System.out.println(ans[i]);
        }

    }
    class Info implements Comparable<Info>{
        int x, dir, id;

        @Override
        public int compareTo(Info o) {
            return x - o.x;
        }


    }*/
}
