package 动态规划.乘积最大子数组;

public class Solution {

    public int maxProduct(int[] nums) {
        int n=nums.length;

        int[] minF=new int[n];
        int[] maxF=new int[n];

        minF[0]=maxF[0]=nums[0];

        for(int i=1;i<n;++i){

            maxF[i]=Math.max(nums[i]*maxF[i-1],Math.max(nums[i],nums[i]*minF[i-1]));
            minF[i]=Math.min(nums[i]*minF[i-1],Math.min(nums[i],nums[i]*maxF[i-1]));
        }
        int ans=maxF[0];

        for(int i=1;i<n;++i){
            ans=Math.max(ans,maxF[i]);
        }

        return ans;

    }

}
