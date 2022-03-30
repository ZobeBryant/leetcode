package 排序.摆动排序2;

import java.util.Arrays;

public class Solution {

    //先排序 在穿插
    public void wiggleSort(int[] nums) {
        int[] assist= nums.clone();
        Arrays.sort(assist);
        int n = nums.length;
        for(int i=1; i<nums.length;i+=2){
            nums[i]=assist[--n];
        }
        for(int i=0;i<nums.length;i+=2){
            nums[i]=assist[--n];
        }

    }

}
