package 剑指Offer.数值的整数次方;

public class Solution {
    // 普通方法 超时
    public double myPow(double x, int n) {
        int flag = 1;
        if(n<0)
            flag=0;
        double res = 1.0;
        for(int i = 0;i < Math.abs(n);++i){
            res *= x;
        }
        if(flag==0)
            return 1 / res;
        else
            return res;
    }
    // 超时
    public double myPow2(double x, int n) {
        int flag = 1;
        double s = x;
        if(n==0)
            return 1.0;
        if(n<0)
            flag=0;
        int i;
        for( i = 2;i <= Math.abs(n);i*=2){
            x*=x;
        }
        double res=x;
        if(i > Math.abs(n)){
            for(int j = i / 2; j <Math.abs(n);++j){
                res*=s;
            }
        }
        if(flag==0)
            return 1 / res;
        else
            return res;
    }
    // 快速幂 迭代
    double quickMul(double x, long n){
        double res = 1.0;
        // 将n看做二进制
        while (n >0){
            if(n%2==1){
                res *= x; //判断低位是否为1
            }
            x *= x;
            n/=2; //左移
        }
        return res;
    }
    double myPow3(double x, int n){
        long N = n; //以防取反溢出
        return n>=0?quickMul(x,n): 1.0/quickMul(x,-N);
    }

    // 快速幂 递归
    double quickMul2(double x, long n){
        if(n==0){
            return 1.0;
        }
        double y = quickMul2(x, n/2);
        return n%2==0?y*y:y*y*x;
    }

}
