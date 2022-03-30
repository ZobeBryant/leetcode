package HOT100.全排列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        backTrack(nums, visited, new ArrayList<>());
        return res;
    }
    private List<List<Integer>> res = new ArrayList<>();
    public void backTrack(int[] nums, boolean[] visited, List<Integer> list){
        if(list.size() == nums.length){
            res.add(new ArrayList<>(list));
            return;
        }
        for(int i = 0; i < nums.length; ++i){
            if(!visited[i]){
                visited[i] = true;
                list.add(nums[i]);
                backTrack(nums, visited, list);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }
    }
}
