package 奇安信提前批.身高;

public class Solution {
    public int TeamNums (int[] height) {
        // write code here
        int n = height.length;
        if(n < 3)
            return 0;
        int count = 0;
        for(int i = 0; i < n; ++i){
            for(int j = i + 1; j < n; ++j){
                for(int k = j + 1; k < n; ++k){
                    if(judge(height, i, j, k))
                        ++count;
                }
            }
        }
        return count;
    }

    private boolean judge(int[] height, int i, int j, int k) {
        if((height[i] > height[j] && height[j] > height[k]) || (height[i] < height[j] && height[j] < height[k])){
            return true;
        }else
            return false;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{1,5,3,2,4};
        Solution sl = new Solution();
        sl.TeamNums(heights);
    }
}
