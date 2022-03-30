package HOT100.和为k的子数组;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 错误
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int i = 0, j = 0, res = 0, sum = 0;
        boolean flag = false;
        while (j < n){
            while ( res < k){
                res += nums[j];
                ++j;
            }
            // j始终指向当前字符串的结束位置的后一个位置
            while (res >= k){
                if(i < j){
                    if(res == k)
                        ++sum;
                    res -= nums[i];
                    // i始终指向当前字符串的开始位置
                    ++i;
                }else{
                    flag = true;
                    break;
                }

            }
            if(flag)
                break;

        }
        return sum;
    }

    // 前缀和
    public int subarraySum1(int[] nums, int k) {
        int count = 0, pre = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1);
        for(int i = 0; i < nums.length; ++i){
            pre += nums[i];
            if(mp.containsKey(pre - k)){
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = {1};
        sl.subarraySum(nums, 0);
    }
}
