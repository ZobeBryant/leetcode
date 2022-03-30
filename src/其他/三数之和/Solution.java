package 其他.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    //排序+双指针
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;

        Arrays.sort(nums);

        List<List<Integer>> ans = new ArrayList<>();


        for(int first=0;first<n;++first){
            if(first>0 && nums[first]==nums[first-1]){
                continue;
            }
            int target= -nums[first];
            int third=n-1;
            for(int second=first+1;second<n;++second){
                if(second > first+1 && nums[second]==nums[second-1] ){
                    continue;
                }

                while(second<third && nums[second]+nums[third]>target){
                    third--;
                }

                if(third==second){
                    break;
                }
                if(nums[second]+nums[third]==target){
                    List<Integer> res = new ArrayList<>();
                    res.add(nums[first]);
                    res.add(nums[second]);
                    res.add(nums[third]);
                    ans.add(res);
                }

            }
        }
        return  ans;

    }

}
