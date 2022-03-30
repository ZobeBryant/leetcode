package 腾讯实习第一次笔试.数字变换;

import java.util.*;

public class Solution {
    public static int divide2(int N) {
        Map<Integer, Integer> visit = new HashMap<>();
        Queue<Integer> que = new LinkedList<>();
        que.offer(N);
        visit.put(N, 1);
        while (!que.isEmpty()) {
            int x = que.poll();
            if (x == 1) {
                break;
            }
            if (!visit.containsKey(x - 1)) {
                visit.put(x - 1, visit.get(x) + 1);
                que.offer(x - 1);
            }
            if (x % 2 == 0 && !visit.containsKey(x / 2)) {
                visit.put(x / 2, visit.get(x) + 1);
                que.offer(x / 2);
            }
            if (x % 3 == 0 && !visit.containsKey(x / 3)) {
                visit.put(x / 3, visit.get(x) + 1);
                que.offer(x / 3);
            }
        }
        return visit.get(1);
    }
}
