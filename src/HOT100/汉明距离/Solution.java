package HOT100.汉明距离;

public class Solution {
    public int hammingDistance(int x, int y) {
        int s = x ^ y, res = 0;
        while (s != 0){
            res += s & 1;
            s >>= 1;
        }
        return res;
    }
}
