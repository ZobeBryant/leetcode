package 剑指Offer.左旋转字符串;

public class Solution {
    public String reverseLeftWords(String s, int n) {
        String s1 = s.substring(0,n);
        String s2 = s.substring(n);
        StringBuffer sb = new StringBuffer();
        sb.append(s2);
        sb.append(s1);
        return sb.toString();
    }
}
