package 腾讯秋招.最优序列;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        sc.nextLine();
        int count = n - k;
        String s = sc.nextLine();
        Stack<Character> st = new Stack<>();
        st.add(s.charAt(0));
        int i = 1;
        while (count > 0 && i < n){
            char ch = s.charAt(i);
            if(count > 0 && !st.isEmpty() && ch > st.peek()){
                st.pop();
                --count;
            }else{
                st.push(ch);
                ++i;
            }
        }
        if(i != n){
            for(; i < n && st.size() < k; ++i){
                char ch = s.charAt(i);
                st.push(ch);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!st.isEmpty()){
            sb.append(st.pop());
        }
        System.out.println(sb.reverse().toString());
    }
}
