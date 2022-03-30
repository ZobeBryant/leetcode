package 贪心.区间问题.用最少数量的箭引爆气球;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    // 合并区间 按照区间终点升序排序
    public int findMinArrowShots(int[][] points) {

        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                //[[-2147483646,-2147483645],[2147483646,2147483647]] 这种情况下会溢出
                //return o1[1]-o2[1];
               /* if (o1[1] > o2[1]) {
                    return 1;
                } else if (o1[1] < o2[1]) {
                    return -1;
                } else {
                    return 0;
                }*/
               return Integer.compare(o1[1], o2[1]);
            }
        });

        int n = points.length;
        int temp = points[0][1];
        int res = 1;
        for(int i = 1; i < n; ++i){
            if(points[i][0] > temp){
                temp = points[i][1];
                res++;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[][] points = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        Solution sl = new Solution();
        sl.findMinArrowShots(points);


    }
}
