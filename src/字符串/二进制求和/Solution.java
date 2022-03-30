package 字符串.二进制求和;

public class Solution {
    public String addBinary(String a,String b){
        int i=a.length()-1,j=b.length()-1,add=0;
        StringBuilder ans=new StringBuilder();

        while(i>=0||j>=0||add!=0){
            int x=i>=0?a.charAt(i)-'0':0;
            int y=j>=0?b.charAt(j)-'0':0;
            int result=x+y+add;
            ans.append(result%2);
            add=result/2;
            --i;
            --j;
        }
        return ans.reverse().toString();
    }


}
