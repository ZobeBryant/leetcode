package 华为秋招.自动驾驶;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        // please define the JAVA input here. For example: Scanner s = new Scanner(System.in);
        // please finish the function body here.
        // please define the JAVA output here. For example: System.out.println(s.nextInt());
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] tmp = new int[k][3];
        int[][] time = new int[k][2];
        for(int i = 0; i < k; ++i){
            for(int j = 0; j < 3; ++j){
                tmp[i][j] = sc.nextInt();
            }
        }
        if(k == 0){
            System.out.println(0);
        }else {
            for(int i = 0; i < k; ++i){
                // start
                time[i][0] = tmp[i][0];
                int count = Math.min(tmp[i][2]-tmp[i][1], tmp[i][1] - (tmp[i][2] - n));
                // end
                time[i][1] = tmp[i][0] + count * 5;
            }
            int[] maxTime = new int[2];
            int curRes = 1;
            int res = 1;
            for(int i = 0; i < k - 1; ++i){
                maxTime[0] = time[i][0];
                maxTime[1] = time[i][1];
                for(int j = i + 1; j < k; ++j){
                    if(time[j][0] == time[j][1] )
                        continue;
                    if(maxTime[1] > time[j][0]){
                        maxTime[0] = time[j][0];
                        maxTime[1] = Math.min(maxTime[1], time[j][1]);
                        curRes ++;
                    }else{
                        res = Math.max(curRes, res);
                        curRes = 0;
                        break;
                    }
                }

            }
            System.out.println(res);
        }

    }
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[][] orders = new int[k][3];
        Map<Integer, Integer> ends = new HashMap<>();
        for(int i = 0; i < k; ++i){
            orders[i][0] = sc.nextInt();
            orders[i][1] = sc.nextInt();
            orders[i][2] = sc.nextInt();
            int a = (orders[i][2] - orders[i][1] + n) % n;
            int b = (orders[i][1] - orders[i][2] + n) % n;
            int end = orders[i][0] + Math.min(a, b) * 5;
            int count = ends.getOrDefault(end, 0);
            ends.put(end, count + 1);
        }
        int res = solve(orders, ends);
        System.out.println(res);
    }
    private static int solve(int[][] orders, Map<Integer, Integer> ends){
        int cur = 0;
        int res = Integer.MAX_VALUE;
        for(int[] order: orders){
            cur ++;
            int count = ends.getOrDefault(order[0], 0) - 1;
            if(count == 0){
                --cur;
                res = Math.min(res, cur);
            }
            ends.put(order[0], count);
        }
        return res;
    }*/
}
