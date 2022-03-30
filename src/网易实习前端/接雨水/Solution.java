package 网易实习前端.接雨水;

public class Solution {
    // 动态规划 下标i接的雨水取决于i左边的元素最大值和i右边的元素最大值 雨水量= min(leftMax[i],rightMax[i])-height[i]
    public int trap(int[] height) {
        int n = height.length;
        if(n == 0)
            return n;
        int[] leftMax = new int[n];
        int[] rightMax = new int[n];
        leftMax[0] = height[0];
        rightMax[n - 1] = height[n - 1];
        for(int i = 1; i < n;++i){
            leftMax[i] = Math.max(leftMax[i-1],height[i]);
        }
        for(int i = n-2; i >= 0; --i){
            rightMax[i] = Math.max(rightMax[i+1],height[i]);
        }
        int res = 0;
        for(int i = 0; i < n; ++i){
            res += Math.min(leftMax[i],rightMax[i]) - height[i];
        }
        return res;
    }
}
