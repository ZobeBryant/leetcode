package 其他.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<>();
        if(nums == null || nums.length<4)
            return res;
        Arrays.sort(nums);
        int n=nums.length;
        for(int first=0;first<n-3;++first){
            if(first>0&&nums[first]==nums[first-1]){
                continue;
            }
            if(nums[first]+nums[first+1]+nums[first+2]+nums[first+3]>target){
                break;
            }
            if(nums[first]+nums[n-3]+nums[n-2]+nums[n-1]<target){
                continue;
            }
            for(int second = first +1;second<n-2;++second){
                   if(second>first+1&&nums[second]==nums[second-1]){
                       continue;
                   }
                   if(nums[first]+nums[second]+nums[second+1]+nums[second+2]>target){
                       break;
                   }
                   if(nums[first]+nums[second]+nums[n-2]+nums[n-1]<target){
                       continue;
                   }
                   int third = second + 1;
                   int fourth = n-1;
                   while (third<fourth){
                       int sum = nums[first]+nums[second]+nums[third]+nums[fourth];
                       if(sum == target){
                           List<Integer> list = new ArrayList<>();
                           list.add(nums[first]);
                           list.add(nums[second]);
                           list.add(nums[third]);
                           list.add(nums[fourth]);
                           res.add(list);

                           while (third<fourth && nums[third]==nums[third+1]){
                               third++;
                           }
                           third++;
                           while (third<fourth && nums[fourth]==nums[fourth-1]){
                               fourth--;
                           }
                           fourth--;
                       }else if(sum<target){
                           third++;
                       }else {
                           fourth--;
                       }

                   }
            }

        }
        return res;
    }
}
