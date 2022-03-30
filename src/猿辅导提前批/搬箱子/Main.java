package 猿辅导提前批.搬箱子;

import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int n = s.length();
        Stack<Character> st1 = new Stack<>();
        Stack<Integer> st2 = new Stack<>();
        st1.push(s.charAt(0));
        int res = 0;
        for(int i = 1; i < s.length(); ++i){
            char ch = s.charAt(i);
            if(st1.peek() == '(' && ch == ')'){
                st1.pop();
                ch = s.charAt(i + 1);
                ++i;
                if(st2.isEmpty()){
                    st2.push(ch - '0');
                }else {
                    int tmp = st2.pop();
                    res += tmp * (ch - '0');
                    st2.push(ch - '0');
                }

            }
        }
     }
}
