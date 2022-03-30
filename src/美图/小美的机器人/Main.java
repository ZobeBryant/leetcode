package 美图.小美的机器人;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<Integer, int[]> map = new HashMap<>();
        int i = 0;
        sc.nextLine();
        while (n-- > 0){
            String tmp = sc.nextLine();
            String[] tmps = tmp.split(" ");
            int d = -1;
            if(tmps[1] == "R"){
                d = 1;
            }
            map.put(i, new int[]{i,Integer.parseInt(tmps[0]),d});

        }

    }
}
