package 网易实习前端.新斐波那契数;

public class Solution {
    public  int test(int n){
        int f0 = 0,f1 = 1, f2 = 2;
        if(n == 0){
            return f0;
        }else if(n == 1){
            return f1;
        }else if(n == 2){
            return f2;
        }
        int res = 0;
        for(int i = 3; i <= n;++i){
            res = f0 + f1 +f2;
            f0 = f1;
            f1 = f2;
            f2 = res;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        System.out.println(sl.test(4));

    }
}
