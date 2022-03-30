package 剑指Offer.旋转数组的最小数字;

public class Solution {
    // 迭代
    public int minArray(int[] numbers) {
        int flag = 0;
        int res=numbers[0];
        for(int i=0;i+1<numbers.length;++i){
            if(numbers[i]>numbers[i+1]){
                flag=1;
                res=numbers[i+1];
            }
            if(flag ==0 && i==numbers.length-2){
                res=numbers[0];
            }
        }
        return res;
    }
    // 二分查找
    int minArray2(int[] numbers){
        int left=0, right=numbers.length-1;
        while (left<right){
            int mid = (right-left)/2+left;
            if(numbers[mid]>numbers[right]){
                left=mid+1;
            }else if(numbers[mid]<numbers[right] ){
                right=mid;
            }else{
                --right;
            }
        }
        return numbers[left];
    }
}
