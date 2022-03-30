package 剑指Offer.第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c,map.getOrDefault(c, 0) +1);
        }
        for(char c: s.toCharArray()){
            if(map.get(c) == 1){
                return  c;
            }

        }
        return ' ';
    }
}
