package 剑指Offer.二进制中1的个数;

public class Solution {
    // 11111111111111111111111111111101 出错 负数存在问题
    public int hammingWeight(int n) {
        int res=0;
        while (n!=0){
            if(n%2==1)
                res++;
            n=n/2;
        }
        return res;
    }
    // 循环检查二进制位 <<左移 >>>逻辑右移 正负数高位都补0
    public int hammingWeight2(int n) {
        int res=0;
        for(int i=0;i<32;++i){
           if((n&(1<<i))!=0){
               res++;
           }
       }
        return res;
    }

    public static void main(String[] args) {

    }
}
