package 贪心.判断子序列;

public class Solution {

    public boolean isSubsequence(String s, String t) {
        int n=s.length();
        int m=t.length();

        if(n==0)
            return true;
        int flag=0;

            for(int i=0;i<m;++i){
                if(t.charAt(i)==s.charAt(flag)){
                    ++flag;
                }
                if(flag==n)
                    return true;
            }

            return false;


    }
}
