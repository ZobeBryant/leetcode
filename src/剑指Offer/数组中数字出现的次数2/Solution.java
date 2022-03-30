package 剑指Offer.数组中数字出现的次数2;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    // 暴力
    public int singleNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int n: nums){
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(Integer key :map.keySet()){
            if(map.get(key) != 3){
                return key;
            }
        }
        return 0;
    }

   // 位运算 取余
   public int singleNumber2(int[] nums) {
        int[] bit = new int[32];
        for(int n: nums){
            int b = 1;
            for(int i = 0; i < 32; ++i){
                if((b & n) != 0){
                    bit[i] += 1;
                }
                b <<= 1;
            }
        }
        int res = 0;
        for(int i = 31; i >= 0; --i){
            res <<= 1;
            res += bit[i] % 3;
        }
        return res;
   }
}
