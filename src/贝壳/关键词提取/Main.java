package 贝壳.关键词提取;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        int max = 0;
        sc.nextLine();
        while (n > 0){
            String s = sc.nextLine().toLowerCase();
            // System.out.println(s);
            map.put(s,map.getOrDefault(s, 0) + 1);
            max = Math.max(max, map.get(s));
            --n;
        }
        String res = "z";
        for(String tmp : map.keySet()){
            if(map.get(tmp) == max){
                if(res.compareTo(tmp) > 0){
                    res = tmp;
                }
            }
        }
        System.out.print(res);
        System.out.print(" ");
        System.out.print(max);
    }
}
