package 贪心.删除问题.非递减数列;

public class Solution {
    // 找到拐点 根据拐点周围情况来决定是拐点下移还是拐点后一个节点上移
    public boolean checkPossibility(int[] nums) {
        int n = nums.length;
        if(n <= 2)
            return true;
        int k = 0;
        for(int i = 1; i < n; ++i){
            if(nums[i] < nums[i-1]) {
                ++k;
                if(k == 2)
                    return false;
                if(i-2>=0){
                    if(nums[i]<nums[i-2])
                        nums[i] = nums[i-1];
                    else
                        nums[i-1] = nums[i];
                }
            }

        }
        return true;
    }

    public static void main(String[] args) {

        int[] nums = new int[]{-1,4,2,3};
        Solution sl = new Solution();
        sl.checkPossibility(nums);
    }
}
