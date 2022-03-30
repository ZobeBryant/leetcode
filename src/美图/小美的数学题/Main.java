package 美图.小美的数学题;
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<String> st = new Stack<>();
        long res = 1;
        for(int i = 0; i < s.length(); ++i){
            String ch = s.substring(i, i + 1);
            if(ch.equals(")")){
                if (!st.peek().equals("(")){
                    long tmp = 1;
                    while (!st.isEmpty() && !st.peek().equals("(")){
                        tmp *= (Long.parseLong(st.pop())) % 1000000007;
                    }
                    if(!st.isEmpty())
                        st.pop();
                    st.push(String.valueOf((tmp + 1) % 1000000007));
                }else{
                    st.pop();
                    st.push("2");
                }
            }else{
                st.push(ch);
            }
        }
        while (!st.isEmpty()){
            res *= Long.parseLong(st.pop());
            res %= 1000000007;
        }
        System.out.println(res);
    }

    /*public static void main(String[] args) {
        System.out.println();
    }*/
}
