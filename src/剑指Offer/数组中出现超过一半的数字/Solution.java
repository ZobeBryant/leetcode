package 剑指Offer.数组中出现超过一半的数字;

import java.util.HashMap;
import java.util.Map;

public class Solution {

    public int majorityElement(int[] nums) {
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int res = 0;
        Map<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
                map.put(nums[i],map.getOrDefault(nums[i] , 0) + 1);
                if(map.get(nums[i]) >= Math.ceil(n / (2 * 1.0))){
                    res = nums[i];
                    break;
                }

        }
        return res;

    }

    public static void main(String[] args) {

    }

}
