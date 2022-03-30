package 好未来.回型遍历;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int[] spin (int[][] arr) {
        // write code here
        List<Integer> list = new ArrayList<>();
        if(arr ==null || arr.length == 0 ){
            return new int[0];
        }
        int m = arr.length;
        int n = arr[0].length;
        int i = 0;
        int count = (Math.min(m, n) + 1) / 2;

        while (i < count){
            for (int j = i; j < n - i; ++j){
                list.add(arr[i][j]);
            }
            for(int j = i + 1; j < m - i; ++j){
                list.add(arr[j][(n - 1 ) - i]);
            }
            for(int j = (n - 1) - (i + 1); j >= i && (m - 1 - i != i); --j){
                list.add(arr[m-1-i][j]);
            }
            for(int j = (m-1)-(i + 1); j >= i + 1 && (n - 1- i) != i; --j){
                list.add(arr[j][i]);
            }
            ++i;
        }
        int [] res = new int[list.size()];
        for(int j = 0; j < list.size(); ++j) {
            res[j] = list.get(j);
        }
        return res;
    }
}
