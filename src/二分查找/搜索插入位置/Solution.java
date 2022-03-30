package 二分查找.搜索插入位置;

public class Solution {

    public int searchInsert(int[] nums,int target){

        int low=0;
        int height=nums.length-1;
        while(low<height){

            int mid=(low+height)/2;

            if(nums[mid]==target)
                return mid;
            if(nums[mid]<target)
                low=mid+1;
            else
                height=mid-1;
        }
        if(nums[low]<target)
            return low+1;

        return low;


    }

    public static void main(String[] args) {
        Solution sl=new Solution();
        int[] nums={1,3,5,6};
        sl.searchInsert(nums,2);
    }

}
