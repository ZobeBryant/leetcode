package 双指针.平方数之和;

public class Solution {
    public boolean judgeSquareSum(int c) {
        int t = (int) Math.sqrt(c);
        int i = 0, j = t;
        while (i <= j){
            int temp = i * i + j * j;
            if(temp == c)
                return true;
            else if(temp > c)
                --j;
            else
                ++i;
        }
        return false;
    }
}
