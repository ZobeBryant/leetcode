package 贪心.区间问题.根据身高重建队列;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    // 一般这种数对，还涉及排序的，根据第一个元素正向排序，根据第二个元素反向排序，或者根据第一个元素反向排序，根据第二个元素正向排序，往往能够简化解题过程。
    public int[][] reconstructQueue(int[][] people) {
        // people[i][0]身高降序排序  若身高相同相同，people[i][1]前面高个人数升序排序
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] != o2[0])
                    return -Integer.compare(o1[0],o2[0]);
                else
                    return Integer.compare(o1[1], o2[1]);
            }
        });
        List<int[]> ans = new ArrayList<>();
        // 低个子不影响高个子的people[i][1]
        for(int i = 0; i < people.length; ++i){
            if(people[i][1] < i){
                ans.add(people[i][1],people[i]);
            }else{
                ans.add(people[i]);
            }
        }

        // 可以简写为
//        for(int[] p: people ){
//            ans.add(p[1],p);
//        }
        return ans.toArray(new int[ans.size()][]);
    }
}
