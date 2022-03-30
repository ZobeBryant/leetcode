package 百度秋招.函数;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; ++i){
            nums[i] = sc.nextInt();
        }
        for(int i = 0; i < n; ++i){
            solve(nums[i]);
            System.out.println(solve(nums[i]));
        }
    }
    public static int solve(int n){
        if(judge(n)){
            return n;
        }else{
            return change(n);
        }
    }
    public static boolean judge(int n){
        int b;
        while (n > 0){
            b = n % 10;
            n /= 10;
            if( b > 3 || b == 0){
                return false;
            }
        }
        return true;
    }
    public static int change(int n){
        int b;
        int res = 0;
        int count = 1;
        while (n > 0){
            b = n % 10;
            n /= 10;
            if(b > 3 || b == 0){
                res += count * 3;
                if(b == 0){
                    n -= 1;
                }
            }else{
                res += count * b;
            }
            count *= 10;
        }
        return  res;
        }
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0){
            char[] s = sc.nextLine().toCharArray();
            int len = s.length;
            StringBuilder res = new StringBuilder();
            for(int i = 0; i < len; ++i){
                int num = s[i] - '0';
                if(num >= 1 && num <= 3){
                    res.append(num);
                    continue;
                }
                if(num == 0){
                    if(s[i - 1] != '0'){
                        int pre = res.charAt(res.length() - 1) - '0';
                        res.deleteCharAt(res.length() - 1);
                        pre--;
                        if(pre != 0){
                            res.append(pre);
                        }
                    }
                }
                res.append("3");
            }
            System.out.println(res.toString());
        }
    }*/
        }
