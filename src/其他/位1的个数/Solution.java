package 其他.位1的个数;

public class Solution {

    //循环和位移动
    public int hammingWeight(int n) {
        int bits=0;
        int mask=1;
        for(int i=0;i<32;++i){
            if((n&mask)!=0){
                ++bits;
            }
            mask <<=1;
        }
        return bits;

    }


    //位操作的小技巧
    //在二进制表示中，数字n中最低位的1总是对应n-1中的0。因此，将n和n-1与预算总是能把n中最低位的1变成0，并保持其他位不变。当数字变成0的时候，就知道没有1的位了，此时返回答案。
    public int hammingWeight2(int n) {

        int sum=0;
        while (n!=0){
            ++sum;
            n&=(n-1);
        }
        return sum;

    }


    public static void main(String[] args) {

        /*Solution sl = new Solution();
        System.out.println(sl.hammingWeight(00000000000000000000000010000000));
*/
        int mask=2;
        int test=3;

        System.out.println(mask&test);


    }
}
