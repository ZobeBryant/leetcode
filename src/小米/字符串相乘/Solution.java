package 小米.字符串相乘;

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0"))
            return "0";
        int m = num1.length();
        int n = num2.length();
        String res = "0";
        for(int i = n - 1; i >= 0; --i){
            StringBuilder sb = new StringBuilder();
            int add = 0;
            for(int j = n - 1; j > i; --j){
                sb.append("0");
            }
            int y = num2.charAt(i) - '0';
            for(int j = m - 1; j >= 0; --j){
                int x = num1.charAt(j) - '0';
                int product = (x * y + add);
                sb.append(product % 10);
                add = product / 10;
            }
            if(add != 0){
                sb.append(add);
            }
            res = addStrings(res, sb.reverse().toString());
        }
        return res;
    }
    public String addStrings(String num1, String num2){
        int i = num1.length() - 1, j = num2.length() - 1;
        int add = 0;
        StringBuilder sb = new StringBuilder();
        while ( i >= 0 || j >= 0 || add != 0){
            int x = i >= 0 ? num1.charAt(i) - '0' : 0;
            int y = j >= 0 ? num2.charAt(j) - '0' : 0;
            int product = x + y + add;
            sb.append(product % 10);
            add = product / 10;
            --i;
            --j;
        }
        return sb.reverse().toString();
    }


}
