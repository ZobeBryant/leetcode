package 动态规划.最大子序和;

public class Solution {

    public int maxSubArray(int[] nums){

       /* int n=nums.length;

        int[] dp=new int[n];

        dp[0]=nums[0];

        int result=dp[0];

        //dp[i]表示第（i+1）个数结尾的连续数组的最大和
        for(int i=1;i<n;++i){
            dp[i]=Math.max(nums[i],dp[i-1]+nums[i]);
            result=Math.max(dp[i],result);
        }

        return result;*/

       int pre=0,maxAns=nums[0];
       for(int x:nums){
           pre=Math.max(pre+x,x);
           maxAns=Math.max(pre,maxAns);
       }
        return maxAns;
    }


}
