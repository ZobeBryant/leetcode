package HOT100.找到所有数组中消失的数字;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        for(int num: nums){
            int x = (num - 1) % n;
            nums[x] += n;
        }
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            if(nums[i] <= n){
                res.add(i + 1);
            }
        }
        return res;
    }
}
