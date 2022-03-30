package HOT100.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        List<int[]> res = new ArrayList<>();
        int[] temp = intervals[0];
        for(int i = 1; i < intervals.length; ++i){
            if(temp[1] < intervals[i][0]){
                res.add(new int[]{temp[0],temp[1]});
                temp = intervals[i];
            }else {
                temp[0] = Math.min(temp[0],intervals[i][0]);
                temp[1] = Math.max(temp[1],intervals[i][1]);
            }
        }
        res.add(new int[]{temp[0], temp[1]});
        int n = res.size();
        int[][] nums = new int[n][2];
        for(int i = 0; i < n; ++i){
            nums[i] = res.get(i);
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[][] intevals = new int[][]{{1,3}, {2,6}, {8, 10}, {15, 18}};
        sl.merge(intevals);
    }
}
