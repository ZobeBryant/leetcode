package 剑指Offer.翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        String s1 = s.trim();
        String[] s2 = s1.split("\\s+");
        StringBuffer sb = new StringBuffer();
        for(int i = s2.length - 1; i >= 0; --i ){
            sb.append(s2[i]);
            if(i != 0)
                sb.append(' ');
        }
        return sb.toString();
    }

}
