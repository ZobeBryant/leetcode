package 其他.两数之和;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    //暴力枚举
    public int[] twoSum(int[] nums, int target) {
        int[] result =new int[2];
        int n=nums.length;
        for(int i=0;i<n;++i){
            for(int j=i+1;j<n;++j){
                if(nums[i]+nums[j]==target){
                    result[0]=i;
                    result[1]=j;
                    j=n;
                    i=n;
                }
            }
        }
        return result;
    }

    //哈希表
    public int[] twoSum2(int[] nums, int target){
        Map<Integer, Integer> hashtable = new HashMap<>();
        for(int i=0;i< nums.length;++i){

            if(hashtable.containsKey(target-nums[i])){
                return new int[]{hashtable.get((target-nums[i])),i};
            }
            hashtable.put(nums[i],i);
        }
        return new int[0];
    }
}
