package HOT100.子集;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        res.add(new ArrayList<>());
        backtrack(nums, 0, new ArrayList<>());
        return res;
    }
    private List<List<Integer>> res = new ArrayList<>();
    public void backtrack(int[] nums, int curIndex, List<Integer> tmp){
        if(curIndex == nums.length){
            return;
        }
        for(int i = curIndex; i < nums.length; ++i){
            tmp.add(nums[i]);
            res.add(new ArrayList<>(tmp));
            backtrack(nums, i + 1,tmp );
            tmp.remove(tmp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = new int[]{1,2,3};
        sl.subsets(nums);
    }
}
