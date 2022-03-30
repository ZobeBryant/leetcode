package 字符串.验证回文串;

public class Solution {
    public boolean isPalindrome(String s){
        StringBuilder pure=new StringBuilder();
        for(int i=0;i<s.length();++i){
            char ch=s.charAt(i);
            if(Character.isLetterOrDigit(ch)){
                pure.append(Character.toLowerCase(ch));
            }
        }
        StringBuilder pure_rev=new StringBuilder(pure).reverse();


        return pure.toString().equals(pure_rev.toString());

    }
}
