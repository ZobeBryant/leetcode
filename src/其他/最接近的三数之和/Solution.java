package 其他.最接近的三数之和;

import java.util.Arrays;

public class Solution {
    //双指针
    public int threeSumClosest(int[] nums, int target) {

        Arrays.sort(nums);

        int n = nums.length;
        //如果target=-1的话 会有问题 Math.abs(Integer.MAX_VALUE - (-1)) = Integer.MIN_VALUE
        int best =100000;
        for(int first=0; first<n;++first){
            if(first>0&& nums[first]==nums[first-1]) {
                continue;
            }
            int third = n - 1;
            int second = first+1;
            while (second<third){
                int sum = nums[first]+nums[second]+nums[third];
                if(sum==target)
                    return target;
                if(Math.abs(sum-target)<Math.abs(best-target)){
                    best = sum;
                }
                if(sum>target){

                    while (second+1<third && nums[third-1]==nums[third]){
                        --third;
                    }
                    --third;
                }else {

                    while (second<third-1 && nums[second]==nums[second+1]){
                        ++second;
                    }
                    ++second;
                }


            }
        }
        return best;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE+1);
    }
}
