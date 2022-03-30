package HOT100.组合总和;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 完全背包
    /*public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        int[][] dp = new int[n + 1][target + 1];
        dp[0][0] = 1;
        for(int i = 1; i <= n; ++i){
            for(int j = 0; j <= target; ++j){
                dp[i][j] = dp[i - 1][j];
                if(j >= candidates[i])
                    dp[i][j] += dp[i][j - candidates[i]];
            }
        }

    }*/
    // 回溯
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, new ArrayList<>(), 0);
        return res;
    }
    private List<List<Integer>> res = new ArrayList<>();
    public void backTrack(int[] candidates, int target, int curSum, List<Integer> curNums, int index){
        if(curSum == target){
            res.add(new ArrayList<>(curNums));
        }
        if(curSum > target)
            return;
        for(int i = index; i < candidates.length; ++i){
            //选择当前节点
            curNums.add(candidates[i]);
            curSum += candidates[i];
            backTrack(candidates, target, curSum, curNums, i);
            //不选择当前节点
            curNums.remove(curNums.size() - 1);
            curSum -= candidates[i];

        }
    }

    public static void main(String[] args) {
        int[] candidates = new int[]{2, 3, 6, 7};
        Solution sl = new Solution();
        sl.combinationSum(candidates, 7);
    }
}
