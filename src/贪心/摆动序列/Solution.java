package 贪心.摆动序列;

public class Solution {
    //将摆动序列看成峰与谷
    public int wiggleMaxLength(int[] nums) {
        int n=nums.length;

        if(n<2)
            return n;

        int preDiff=nums[1]-nums[0];

        int res=preDiff!=0?2:1;

        for(int i=2;i<n;++i){
            int diff=nums[i]-nums[i-1];

            if(diff>0 && preDiff<=0||diff<0 && preDiff>=0){
                res++;
                preDiff=diff;
            }

        }
        return res;

    }

}
