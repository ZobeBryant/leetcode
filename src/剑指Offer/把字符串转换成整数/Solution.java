package 剑指Offer.把字符串转换成整数;

import java.math.BigInteger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    // 太麻烦
    public int strToInt(String str) {
        String s = str.trim();
        if(s.length() == 0 || s.substring(0,1).matches("[^0-9+\\-]"))
            return 0;
        int flag = 2;
        if(s.charAt(0) == '-')
            flag = -1;
        else if(s.charAt(0) == '+')
            flag = 1;
        int start = flag < 2 ? 1 : 0;
        flag = flag == 2 ? 1 : flag;
        int end = start;
        while (end < s.length()){
            if(s.substring(end, end+1).matches("\\D"))
                break;
            end++;
        }
        if(start == end)
            return 0;
       if(end - start == 10){
           long temp = Long.parseLong(s.substring(start, end));
           if(flag == 1){
               if(temp >= Integer.MAX_VALUE){
                    return Integer.MAX_VALUE;
               }
           }else{
               if(-1 * temp <= Integer.MIN_VALUE){
                   return Integer.MIN_VALUE;
               }
           }

        }else if(end - start > 10){
           while ( start < s.length() && s.charAt(start) == '0'){
               start ++;
           }
           start--;
           if(end - start > 10 && flag == 1)
               return Integer.MAX_VALUE;
           else if (end - start  > 10 && flag == -1)
               return Integer.MIN_VALUE;
        }
        return Integer.parseInt(s.substring(start, end)) * flag ;

    }
    // 简单方法
    int strToInt2(String str){
        String reg = "^\\s*([+-]?\\d+)";
        Pattern r = Pattern.compile(reg);
        Matcher m = r.matcher(str);
        if(!m.find()) return 0;
        //group是针对（）来说的，group（0）就是指的整个串，group（1） 指的是第一个括号里的东西，group（2）指的第二个括号里的东西。
        BigInteger ans = new BigInteger(m.group(1));
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MIN_VALUE))) < 0) return Integer.MIN_VALUE;
        if(ans.compareTo(new BigInteger(String.valueOf(Integer.MAX_VALUE))) > 0) return Integer.MAX_VALUE;
        return ans.intValue();

    }
    public static void main(String[] args) {
        Solution sl = new Solution();
        sl.strToInt2("2147483646");
    }
}
