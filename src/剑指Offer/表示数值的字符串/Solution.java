package 剑指Offer.表示数值的字符串;

public class Solution {
    public boolean isNumber(String s) {
        String reg1 = ".*[A-Za-z]+.*";
        String reg2 = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)((?i)e)[-+]?\\d+$";
        String reg3 = "^[+-]?(\\d+(\\.\\d*)?|\\.\\d+)$";
        String s2 = s.trim();
        if(s2.matches(reg1)){
            if(s2.matches(reg2)){
                return  true;
            }else {
                return false;
            }
        }else{
            if(s2.matches(reg3)){
                return true;
            }else {
                return false;
            }
        }
    }

    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.isNumber(".");
    }
}
