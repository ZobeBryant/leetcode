package HOT100.最长连续序列;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    // 暴力
    public int longestConsecutive(int[] nums) {
        Arrays.sort(nums);
        int max = 1, count = 1, n = nums.length;
        if(n == 0)
            return 0;
        for(int i = 0; i < n - 1; ++i){
            if(nums[i] + 1 == nums[i+1]){
                ++count;
                max = Math.max(count, max);
            }else if(nums[i] == nums[i +1]){
                continue;
            } else{
                count = 1;
            }
        }
        return max;
    }

    // 哈希表 o(n)
    public int longestConsecutive2(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums){
            set.add(num);
        }
        int max = 0;
        for(int num : set){
            if(!set.contains(num - 1)){
                int count = 1;
                int curNum = num;
                while (set.contains(curNum + 1) ){
                    count ++;
                    curNum ++;
                }
                max = Math.max(max, count);
            }

        }
        return max;
    }

    public int longestConsecutive3(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int n : nums){
            set.add(n);
        }
        int res = 0;
        for(int n : set){
            if(!set.contains(n-1)){
                int count = 1;
                int curNum = n;
                while (set.contains(curNum + 1)){
                    ++count;
                    ++curNum;
                }
                res =  Math.max(count ,res);
            }
        }
        return res;
    }

}
