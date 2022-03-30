package bilibili秋招.计算共有的最小元素;

import org.w3c.dom.css.CSSPrimitiveValue;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
/*    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int res = -1;
        int count = 0;
        Map<Integer, Integer> map = new HashMap<>();
        while (sc.hasNextLine()){
            String s = sc.nextLine();
            String[] arrs = s.split(",");
            if(s.equals("")){
                break;
            }
            for(int i = 0; i < arrs.length; ++i){
                int num =Integer.parseInt(arrs[i]);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
            ++count;
        }
        for(int key : map.keySet()){
            if(map.get(key) == count){
                res = key;
                break;
            }

        }
        System.out.println(res);
    }*/
    public static void main(String[] args) {
        LinkedHashMap<String , Integer> map = new LinkedHashMap<String, Integer>();
        map.put("d", 2);
        map.put("c", 1);
        map.put("b", 1);
        map.put("a", 3);
        map.put("e", 1);
        map.put("d", 3);
        map.put("c", 2);
        System.out.println(map.values());

    }
}
