package 其他.移除元素;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

public class Solution {

    //双指针 一个指针指向当前满足条件的数组下表，一个指针遍历原数组
    public int removeElement(int[] nums, int val) {
        int i = 0;
        for(int j=0;j<nums.length;++j){
            if(nums[j]!=val){
                nums[i]=nums[j];
                ++i;

            }
        }
        return i;
    }


    public int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;

        while (i<n){
            if(nums[i]==val){
                nums[i]=nums[n-1];
                --n;
            }else{
                ++i;
            }
        }
        return i;

    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int[] nums={3,2,2,3};
        sl.removeElement2(nums,3);
    }

}
