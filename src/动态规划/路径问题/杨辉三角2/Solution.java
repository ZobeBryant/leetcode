package 动态规划.路径问题.杨辉三角2;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        res.add(1);
        for(int i = 2; i <= rowIndex + 1; ++i){
            List<Integer> tmp = new ArrayList<>();
            for(int j = 1; j <= i; ++j){
                if(j == 1 || j == i)
                    tmp.add(1);
                else{
                    tmp.add(res.get(j - 1) + res.get(j - 2) );
                }
            }
            res = tmp;
        }
        return res;
    }
}
