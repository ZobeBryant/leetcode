package 小米.所有子集2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;
        List<Integer> t = new ArrayList<>();
        for(int mask = 0; mask < (1 << n); ++mask){
            t.clear();
            for(int i = 0; i < n; ++i){
                if((mask & (1 << i)) != 0){
                    t.add(nums[i]);
                }
            }
            res.add(new ArrayList<>(t));
        }
        return res;
    }
}
