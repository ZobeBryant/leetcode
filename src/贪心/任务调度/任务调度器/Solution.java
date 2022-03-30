package 贪心.任务调度.任务调度器;

import java.util.*;

public class Solution {

    // 模拟法 优先剩余执行次数最多的任务
    public int leastInterval(char[] tasks, int n) {
        Map<Character, Integer> feq = new HashMap<>();
        for(char ch: tasks){
            feq.put(ch, feq.getOrDefault(ch,0) + 1);
        }
        // 不同种类任务总数
        int m = feq.size();
        List<Integer> nextValid = new ArrayList<>();// 下一次执行时间
        List<Integer> rest = new ArrayList<>();// 同种任务剩余数量
        Set<Map.Entry<Character, Integer>> entries = feq.entrySet();
        for(Map.Entry<Character, Integer> entry: entries){
            int val = entry.getValue();
            nextValid.add(1);
            rest.add(val);
        }
        int time = 0;
        for(int i = 0; i < tasks.length; ++i){
            ++time;
            int minNextValid = Integer.MAX_VALUE;
            for(int j = 0; j < m; ++j){
                if(rest.get(j) != 0){
                    minNextValid = Math.min(minNextValid, nextValid.get(j));
                }
            }
            time = Math.max(time, minNextValid);
            int best = -1;
            for(int j = 0; j < m; ++j){
                if(rest.get(j) !=0 && nextValid.get(j) <= time ){
                    if(best == -1 || rest.get(j) > rest.get(best)){
                        best = j;
                    }
                }
            }
            nextValid.set(best, time + n + 1);
            rest.set(best, rest.get(best) - 1);
        }
        return time;
    }

    public int leastInterval2(char[] tasks, int n) {
        int[] buckets = new int[26];
        for(int i = 0; i < tasks.length; ++i){
            buckets[tasks[i] - 'A'] ++;
        }
        Arrays.sort(buckets);
        int maxTimes = buckets[25];
        int maxCount = 1;
        for(int i = 25; i >=1; --i){
            if (buckets[i] == buckets[i-1])
                maxCount++;
            else
                break;
        }
        return Math.max(tasks.length, (maxTimes - 1 ) * (n + 1) + maxCount);
    }
}
