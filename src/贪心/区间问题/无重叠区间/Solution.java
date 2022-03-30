package 贪心.区间问题.无重叠区间;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    // 按照区间终点升序排序
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[1] == o2[1])
                    return o2[0] - o1[0];
                // 区间终点升序排序
                return o1[1] - o2[1];
            }
        });

        int n = intervals.length;
        int res = 0;
        int temp = intervals[0][1];
        for(int i = 1; i < n; ++i){
               if(intervals[i][0] >= temp)
                   temp = intervals[i][1];
               else
                   res++;
        }

        return res;
    }


    public static void main(String[] args) {
        int[][] intervals = new int[][]{{1,100},{11,22},{1,11},{2,12}};
        Solution sl = new Solution();
        sl.eraseOverlapIntervals(intervals);

    }
}
