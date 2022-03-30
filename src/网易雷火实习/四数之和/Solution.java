package 网易雷火实习.四数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public int[][] findNumber (int[] nums, int target) {
        List<int[]> res = new ArrayList<>();
        Arrays.sort(nums);
        for(int a = 0; a < nums.length - 3; ++a){
            if(a > 0 && nums[a] == nums[a - 1])
                continue;
            if(nums[a] +nums[a + 1] + nums[a + 2] + nums[a + 3] > target)
                break;
            if(nums[a] + nums[nums.length - 1] + nums[nums.length - 2] +nums[nums.length - 3] < target)
                continue;
            for(int b= a + 1; b < nums.length - 2; ++b){
                if(b > a + 1 && nums[b] == nums[b-1])
                    continue;
                if(nums[a] + nums[b] +nums[b+1] + nums[b+2] > target)
                    break;
                if(nums[a] + nums[b] + nums[nums.length-1] + nums[nums.length - 2] < target)
                    continue;
                int l = b+1, r = nums.length-1;
                while (l < r){
                    int sum = nums[a] + nums[b] + nums[l] + nums[r];
                    if(sum == target){
                        res.add(new int[] {nums[a], nums[b], nums[l], nums[r]});
                        while (l < r && nums[l] == nums[l + 1]){
                            ++l;
                        }
                        ++l;
                        while (l < r && nums[r] == nums[r - 1]){
                            --r;
                        }
                        --r;
                    }else if(sum < target ){
                        l++;
                    }else{
                        --r;
                    }

                }
            }
        }
        return res.toArray(new int[res.size()][4]);
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] test = {5,0,-6,0,6,-5};
        int target = 0;
        sl.findNumber(test, target);
    }
}
