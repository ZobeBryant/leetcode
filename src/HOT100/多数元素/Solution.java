package HOT100.多数元素;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        int mid = nums.length / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length;++i ){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
            if(map.get(nums[i]) > mid){
                return nums[i];
            }
        }
        return -1;
    }
    // 投票法
    public int majorityElement2(int[] nums) {
        Integer candidate = null;
        int count = 0;
        for(int num : nums){
            if(count == 0)
                candidate = num;
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }

}
