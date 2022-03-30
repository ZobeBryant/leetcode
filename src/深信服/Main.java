package 深信服;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int cur = 0;
        int count = 1;
        while (cur < n - 1){
            if(s.charAt(cur)  == s.charAt(cur + 1)){
                while (s.charAt(cur)  == s.charAt(cur + 1)){
                    ++count;
                    ++cur;
                }
                if(count >= 3){
                    if(sb.length() > 0)
                        sb.deleteCharAt(sb.length() - 1);
                    ++cur;
                }
                ++cur;
                if(cur > 1 && sb.length() > 1 &&  s.charAt(cur) == sb.charAt(sb.length() - 1)){
                    count = 2;
                    sb.deleteCharAt(sb.length() - 1);
                }else{
                    count = 1;
                }
            }else {
                sb.append(s.charAt(cur));
                ++cur;
            }


        }
        if(s.charAt(n - 1) != sb.charAt(sb.length() - 1)){
            sb.append(s.charAt( n - 1));
        }else{
            sb.deleteCharAt(sb.length() - 1);
        }
        String res = sb.toString();
        if(res.equals(""))
            System.out.println("SANGFOR");
        else
            System.out.println(res);

    }
}
