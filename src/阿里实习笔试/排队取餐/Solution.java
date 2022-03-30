package 阿里实习笔试.排队取餐;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        while (c-- > 0){
            int n = sc.nextInt();
            Queue<int[]> q = new LinkedList<>();
            for (int i = 0; i < n; ++i){
                int arr = sc.nextInt();
                int time = sc.nextInt();
                q.offer(new int[]{arr,time});
            }
            int[] res = new int[n];
            int time = 1;
            int index = 0;
            while (!q.isEmpty()){
                int[] temp = q.peek();
                if(temp[0] <= time && temp[1] >=time){
                    q.poll();
                    res[index] = time;
                    ++time;
                    ++index;
                }else if(temp[1] < time){
                    q.poll();
                    res[index] = 0;
                    ++index;
                }else {
                    ++time;
                }

            }
            for(int i = 0; i < n; ++i){
                if(i != n-1)
                    System.out.print(res[i] + " ");
                else
                    System.out.println(res[i]);
            }

        }
    }
}
