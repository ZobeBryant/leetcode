package 贪心.分配问题.分发糖果;

import java.util.Arrays;

public class Solution {
    // 贪心策略：在每次遍历中，只考虑并更新相邻一侧的大小关系
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] candies = new int[n];
        Arrays.fill(candies, 1);
        // 从左往右遍历
        for(int i = 1; i < n; ++i){
            if(ratings[i] > ratings[i-1])
                candies[i] = candies[i-1] + 1;
        }
        // 从右往左遍历
        for(int i = n-2; i>=0; --i){
            if(ratings[i] >ratings[i+1] && candies[i] <= candies[i+1] )
                candies[i] = candies[i+1] + 1;
        }
        int res = 0;
        for(int i = 0; i < n; ++i){
            res += candies[i];
        }
        return res;
    }
}
