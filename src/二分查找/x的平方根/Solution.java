package 二分查找.x的平方根;

public class Solution {

    public int mySqrt(int x){

        int low=0,height=x,ans=-1;
        while(low<=height){
            int mid=low+(low-height)/2;
            if((long)mid*mid<=x){ //x/mid==mid 直接mid*mid可能会溢出
                ans=mid;
                low=mid+1;
            }else
                height=mid-1;
        }
        return ans;

    }



}
