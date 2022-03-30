package 剑指Offer.扑克牌中的顺子;

import java.util.Arrays;

public class Solution {
    // [11,0,9,0,0] 过不了 ...但是怎么会有三个大小王 ....盲猜多副牌
    public boolean isStraight(int[] nums) {
        Arrays.sort(nums);
        // 统计大小王
        int t = 0, countMax = 0, count = 0;
        if(nums[0] == 0){
            countMax += 1;
            nums[0] = Integer.MIN_VALUE;
            if(nums[1] == 0){
                countMax += 1;
                nums[1] = Integer.MIN_VALUE;
            }

        }
        for(int i = 1; i < nums.length; ++i){
            int temp = nums[i] - nums[i-1];
            if(temp == 1)
                count +=1;
            else
                t = temp;
        }
        if(count == 4)
            return true;
        else if(count == 3 && countMax == 1)
            return true;
        else if(count == 2 && t == 2 && countMax == 1)
            return true;
        else if(count == 1 && t == 3 && countMax == 2)
            return true;
        return false;

    }

    public boolean isStraight2(int[] nums) {
        Arrays.sort(nums);
        int min = 0;
        for(int i = 0; i < 4; ++i){
            if(nums[i] == 0) min++;
            else if(nums[i] == nums[i+1]) return false;
        }
        return nums[4] - nums[min] < 5;
    }
}
