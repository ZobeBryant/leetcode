package HOT100.前k个高频元素;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap();
        for(int i = 0; i < nums.length; ++i){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }
        // 堆
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return Integer.compare(o1[1], o2[1]);
            }
        });

        /*int[][] keyValue = new int[map.size()][2];
        int index = 0;
        for(int key : map.keySet()){
            int val = map.get(key);
            keyValue[index][0] = key;
            keyValue[index][1] =val;
            ++index;
        }
        for(int i = 0; i < map.size(); ++i){
            if(i < k){
                queue.add(keyValue[i]);
            }else{
                int[] item = queue.peek();
                if(item[1]  < keyValue[i][1]){
                    queue.poll();
                    queue.add(keyValue[i]);
                }
            }
        }*/
        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            int num = entry.getKey(), count = entry.getValue();
            if(queue.size() == k){
                if(queue.peek()[1] < count){
                    queue.poll();
                    queue.offer(new int[]{num, count});
                }else{
                    queue.offer(new int[]{num, count});
                }
            }
        }
        int[] res = new int[k];
        while (k > 0){
            res[k-1] = queue.poll()[0];
            --k;
        }
        return res;
    }
}
