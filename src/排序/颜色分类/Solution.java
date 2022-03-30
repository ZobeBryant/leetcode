package 排序.颜色分类;

public class Solution {

    //冒泡排序
    public void sortColors(int[] nums) {
        for(int i=0;i<nums.length-1;++i){
            for(int j=0;j<nums.length-i-1;++j){
                if(nums[j]>nums[j+1]){
                    int temp;
                    temp=nums[j];
                    nums[j]=nums[j+1];
                    nums[j+1]=temp;
                }
            }
        }
    }

    //双指针 选出0 和 1
    public void sortColors2(int[] nums) {
        int n=nums.length;
        int p0=0,p1=0;

        for(int i=0;i<n;++i){
            if(nums[i]==1){
                int temp=nums[p1];
                nums[p1]=nums[i];
                nums[i]=temp;
                ++p1;
            }else if(nums[i]==0){
                int temp=nums[p0];
                nums[p0]=nums[i];
                nums[i]=temp;
                if(p0<p1){
                    temp = nums[p1];
                    nums[p1]=nums[i];
                    nums[i]=temp;
                }
                ++p0;
                ++p1;
            }
        }

    }
}
