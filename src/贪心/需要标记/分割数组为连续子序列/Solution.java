package 贪心.需要标记.分割数组为连续子序列;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution {
    // 哈希表 + 最小堆
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for(int x: nums){
            if(!map.containsKey(x)){
                map.put(x, new PriorityQueue<>());
            }
            if(map.containsKey(x-1)){
                int prevLength = map.get(x-1).poll();
                map.get(x).offer(prevLength + 1);
                if(map.get(x-1).isEmpty())
                    map.remove(x-1);
            }else{
                map.get(x).offer(1);
            }
        }
        // 存储map的value
        Set<Map.Entry<Integer, PriorityQueue<Integer>>> entrySet = map.entrySet();
        for(Map.Entry<Integer, PriorityQueue<Integer>> entry:entrySet){
            PriorityQueue<Integer> queue = entry.getValue();
            if(queue.peek() < 3)
                return false;
        }
        return true;
    }
}
