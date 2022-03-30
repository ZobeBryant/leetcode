package 剑指Offer.打印从1到最大的n位数;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Solution {
    public int[] printNumbers(int n) {
        int N = (int) Math.pow(10,n)-1;
        int[] res = new int[N];
        for (int i=0;i<N;++i){
            res[i]=i+1;
        }
        return res;
    }
    private List<String> res;
    // 考虑到大数 用字符串保存
    public List<String> printNumbers2(int n){
        res = new ArrayList<>();
        for(int bit=1;bit<=n;++bit){
            for(char first='1';first<='9';++first){
                char num[] = new char[bit];
                num[0] = first;
                dfs(1,num,bit);
            }
        }
        return res;
    }
    public void dfs(int index,char num[],int bit){
        if(index==bit) {
            res.add(String.valueOf(num));
            return;
        }
        for(char i = '0'; i <= '9'; ++i){
            num[index]=i;
            dfs(index+1,num,bit);
        }
    }
}
