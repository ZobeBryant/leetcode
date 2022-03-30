package 阿里实习笔试.拿糖果;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); int k = sc.nextInt();
        if(k == n){
            System.out.println(1);;
        }
        int[] temp = new int[n];
        for(int i = 0; i < n; ++i){
            temp[i] = sc.nextInt();
        }
        Deque<Integer> deque = new LinkedList<>();
        int i = 0;
        int res = 0;
        int res_temp = 0;
        int max_i = 0;
        int count = n;
        while (count-->= 0){
            if(deque.size() < k){
                res_temp += temp[i % n];
                res = res_temp;
                deque.addLast(temp[i % n]);
            }else {
                res_temp += temp[i % n] - deque.peekFirst();
                if(res < res_temp ){
                    res =res_temp;
                    max_i = (i +1) - k;
                }
                deque.pollFirst();
                deque.addLast(temp[i % n]);
            }
            ++i;
        }
        System.out.println(max_i + 1);

    }
}
