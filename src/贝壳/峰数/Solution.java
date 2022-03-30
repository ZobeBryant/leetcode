package 贝壳.峰数;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int solve (int n) {
        // write code here
        int res = 0;
        for(int i = 1; i <= n; ++i ){
            if(judge(i))
                res++;
        }
        return  res;
    }

    public boolean judge(int num){
        int bit = 0;
        List<Integer> list = new ArrayList<>();
        while (num != 0){
            ++bit;
            list.add(num % 10);
            num = num / 10;
        }
        if(bit % 2 == 0)
            return false;
        int mid = (1 + bit) / 2;
        for(int i = 0; i < mid - 1; ++i){
            if(list.get(i) >= list.get(i + 1))
                return false;
        }
        for(int i = mid - 1; i < bit - 1; ++i){
            if(list.get(i) <= list.get(i + 1))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        int res = sl.solve(999);
        System.out.println(res);
    }
}
