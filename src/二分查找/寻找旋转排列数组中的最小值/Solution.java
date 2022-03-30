package 二分查找.寻找旋转排列数组中的最小值;

public class Solution {

    public int findMin(int[] nums){
        int n=nums.length;
        if(n==1)
            return nums[0];

        int l=0,r=n-1;
        if(nums[l]<=nums[r])
            return nums[0];

        while(l<=r){
            int mid =(l+r)/2;

            if(nums[mid]>nums[mid+1])
                return nums[mid+1];
            if(nums[mid-1]>nums[mid])
                return nums[mid];

            if(nums[0]<nums[mid])
                l=mid+1;
            else
                r=mid-1;
        }

        return -1;
    }

}
