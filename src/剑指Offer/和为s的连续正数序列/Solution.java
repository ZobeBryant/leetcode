package 剑指Offer.和为s的连续正数序列;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    // 超时
    public int[][] findContinuousSequence(int target) {
        List<int[]>  res = new ArrayList<>();
        for(int i = 1; i < target; ++i){
            int[] temp = sequence(i, target);
            if(temp.length != 0 )
                res.add(temp);
        }
        return res.toArray(new int[res.size()][]);
    }

    public int[] sequence(int start, int target){

        int sum = 0;
        int p = start;
        while (p < target ){
            sum += p;
            if(sum == target){
                int [] res = new int[p - start + 1];
                for(int i = start; i <= p; ++i){
                    res[i - start] = i;
                }
                return res;
            }

            if(sum > target)
                break;
            p++;
        }
        return new int[0];

    }

    // 双指针
    public int[][] findContinuousSequence2(int target) {
        List<int[]> res = new ArrayList<>();
        int l = 1, r = 2;
        while (l < r){
            int sum = (r + l) * (r - l + 1) / 2;
            if(sum == target){
                int[] temp = new int[r - l + 1];
                for(int i = l; i <= r; ++i){
                    temp[i - l] = i;
                }
                res.add(temp);
                l++;
            }else if(sum > target){
                l++;
            }else{
                r++;
            }
        }
        return res.toArray(new int[res.size()][]);
    }

}
