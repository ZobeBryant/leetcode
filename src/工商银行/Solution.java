package 工商银行;

public class Solution {
    public static void main(String[] args) {

        String s1 = "12";
        String s2 = "1" + "2";
        String s3 =  new String("12");
        String s4= new String("1") + new String("2");
        System.out.println(s1 == s2);
    }

}
