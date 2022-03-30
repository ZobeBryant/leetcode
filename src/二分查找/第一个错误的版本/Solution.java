package 二分查找.第一个错误的版本;

public class Solution {

    Boolean isBadVersion(int version){

        return true;
    }

    public int firstBadVersion(int n){
        int l=1,r=n;
        while ((l<r)){
            //写成 mid=（l+r）/2的形式 可能会溢出从而超出时间限制
            int mid=l+(r-l)/2;
            if(isBadVersion(mid)) r=mid;
            else l=mid+1;
        }
        return l;
    }

}
