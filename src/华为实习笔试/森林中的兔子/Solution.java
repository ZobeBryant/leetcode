package 华为实习笔试.森林中的兔子;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int numRabbits(int[] answers) {
        int n = answers.length;
        if(n == 0)
            return 0;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            /*if(map.containsKey(answers[i])){
                map.put(answers[i],map.get(answers[i]) + 1);
            }else {
                map.put(answers[i], 1);
            }*/
            map.put(answers[i], map.getOrDefault(answers[i],0) + 1);
        }
        int res = 0;
        for(Integer key : map.keySet()){
            int count = map.get(key);
            if(count % (key + 1) == 0){
                res += (count / (key + 1)) * (key + 1);
            }else{
                res +=(count / (key + 1) + 1)  * (key + 1);
            }

        }
        return res;
    }
}
