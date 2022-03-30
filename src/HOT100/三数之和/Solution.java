package HOT100.三数之和;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    // 三指针 超时
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        if(n <= 2)
            return res;
        Arrays.sort(nums);
        for(int i = 0; i < n - 2; ++i){
            // 第三个指针指向数组末尾，这样在第二指针进行遍历时，第三指针不用回退，保持之前位置。因为第二指针指向的数组
            int k = n - 1;
            if( i > 0 && nums[i] == nums[i-1])
                continue;
            for(int j = i + 1; j < n - 1; ++j){
                if( j > i + 1 && nums[j] == nums[j - 1])
                    continue;
                while (j < k && nums[i] + nums[j] + nums[k]  > 0){
                    --k;
                }
                if(j == k)
                    break;
                if(nums[i] + nums[j] + nums[k]  == 0){
                    res.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k])));
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {-1, 0, 1, 2, -1, -4};
        sl.threeSum(nums);
    }
}
