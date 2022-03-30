package HOT100.全排列2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        boolean[] visited = new boolean[n];
        Arrays.sort(nums);
        backtrack(nums,visited, new ArrayList<>(), 0);
        return res;
    }
    private List<List<Integer>> res = new ArrayList<>();
    public void backtrack(int[] nums, boolean[] visited, List<Integer> tmp, int index){
        if(index == nums.length){
            res.add(new ArrayList<>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
                if(visited[i] || (i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]))
                    continue;
                visited[i] = true;
                tmp.add(nums[i]);
                backtrack(nums, visited, tmp, index + 1);
                tmp.remove(tmp.size() - 1);
                visited[i] = false;

        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums = new int[]{1, 1, 2};
        sl.permuteUnique(nums);
    }

}
