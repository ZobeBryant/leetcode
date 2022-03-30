package 动态规划.路径问题.杨辉三角;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 1; i <= numRows; ++i){
            List<Integer> temp = new ArrayList<>();
            for(int j = 1; j <= i; ++j){
                if(j == 1 || j == i)
                    temp.add(1);
                else {
                    int num = res.get(res.size() - 1).get(j-2) + res.get(res.size() - 1).get(j - 1);
                    temp.add(num);
                }
            }
            res.add(temp);
        }
        return res;
    }
}
