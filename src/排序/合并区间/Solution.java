package 排序.合并区间;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution {
    //按照区间的左端点排序 贪心
    public int[][] merge(int[][] intervals) {
        if(intervals.length < 2)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> merged = new ArrayList<>();
        for(int i=0;i<intervals.length;++i){
            int l=intervals[i][0];
            int r=intervals[i][1];

            if(merged.size()==0 || merged.get(merged.size()-1)[1]<l)
                merged.add(intervals[i]);
            else{
                merged.get(merged.size()-1)[1]=Math.max(merged.get(merged.size()-1)[1],r);
            }

        }
        return merged.toArray(new int[merged.size()][]);

    }


}
