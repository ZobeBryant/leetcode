package 剑指Offer.替换空格;

public class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<s.length();++i){
            char c = s.charAt(i);
            if(c==' '){
                sb.append("%20");
            }else{
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        String s = "   ";
        sl.replaceSpace(s);
    }
}
