package HOT100.颜色分类;

public class Solution {
    // 三指针
    public void sortColors(int[] nums) {
        int left = 0, right = nums.length - 1, cur = 0;

            while (left < right && nums[left] == 0){
                ++left;
            }
            while (left < right && nums[right] == 2){
                --right;
            }
            cur = left;
            while (cur <= right){
                if(nums[cur] == 2){
                    nums[cur] = nums[right];
                    nums[right] = 2;
                    while (cur < right  && nums[right] == 2)
                        --right;
                    if(nums[cur] != 0){
                        ++cur;
                    }
                }else if(nums[cur] == 0){
                    nums[cur] = nums[left];
                    nums[left] = 0;
                    ++left;
                    if(nums[cur] != 2){
                        ++cur;
                    }
                }else{
                    ++cur;
                }
            }
    }

    // 三指针 简便写法
    public void sortColors2(int[] nums) {
        int p = 0, q = nums.length -1;
            for(int i = 0; i <= q; ++i){
                while (i < q && nums[i] == 2){
                    nums[i] = nums[q];
                    nums[q] = 2;
                    --q;
                }
                if(nums[i] == 0 ){
                    nums[i] = nums[p];
                    nums[p] = 0;
                    ++p;
                }
        }
    }

}
