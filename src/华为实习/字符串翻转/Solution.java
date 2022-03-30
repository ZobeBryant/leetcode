package 华为实习.字符串翻转;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;
public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        char[] chars = str.toCharArray();
        String res = solve(chars);
        System.out.println(res);
    }

//    private static String solve(char[] str) {
//        Deque<Character> deque = new LinkedList<>();
//        for (char c : str) {
//            if (c == ')') {
//                LinkedList<Character> tmp = new LinkedList<>();
//                while (!deque.isEmpty() && deque.peek() != '(') {
//                    tmp.addLast(deque.pop());
//                }
//                if (!deque.isEmpty() && deque.peek() == '(') {
//                    deque.pop();
//                }
//                while (!tmp.isEmpty()) {
//                    deque.push(tmp.pollFirst());
//                }
//            } else {
//                deque.push(c);
//            }
//        }
//        StringBuilder sb = new StringBuilder();
//        while (!deque.isEmpty()) {
//            sb.append(deque.pollLast());
//        }
//        return sb.toString();
//    }
    public static String solve(char[] str){
        Deque<Character> deque = new LinkedList<>();
        for(char c: str){
            if( c == ')'){
                Deque<Character> temp = new LinkedList<>();
                while (!deque.isEmpty() && deque.peekLast() != '('){
                    temp.offerLast(deque.pollLast());
                }
                if(!deque.isEmpty() && deque.peekLast() == '(')
                    deque.pollLast();
                while (!temp.isEmpty() ){
                    deque.offerLast(temp.pollFirst());
                }
            }else{
                deque.offerLast(c);
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()){
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }
}
