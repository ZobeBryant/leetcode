package 其他.盛最多水的容器;

public class Solution {

    //双指针
    public int maxArea(int[] height) {
        int l = 0;
        int r = height.length-1;

        int ans=0;

        while (l<r){
            int area = Math.min(height[l],height[r])*(r-l);
            if(area>ans)
                ans =area;
            if(height[l]<height[r]){
                ++l;
            }else{
                --r;
            }
        }
        return ans;
    }

}
