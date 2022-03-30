package HOT100.字母异位词分组;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; ++i){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String str = new String(chars);
            List list = map.getOrDefault(str, new ArrayList<>());
            list.add(strs[i]);
            map.put(str, list);
        }
        return new ArrayList<>(map.values());
    }
}
