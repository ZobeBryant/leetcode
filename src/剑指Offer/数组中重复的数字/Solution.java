package 剑指Offer.数组中重复的数字;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer,Integer> map = new HashMap<>();
        int result = 0;
        for(int n : nums){
            if(map.containsKey(n)){
                result= n;
                break;
            }else {
                map.put(n,1);
            }
        }
        return result;
    }
}
