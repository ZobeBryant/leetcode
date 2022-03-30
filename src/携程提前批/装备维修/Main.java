package 携程提前批.装备维修;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int c = sc.nextInt();
        int d = sc.nextInt();
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int len1 = s1.length, len2 = s2.length;
        int maxLen = Integer.MAX_VALUE;
        for(int i = 0; i <= len2 - len1; ++i){
            int count = 0;
            for(int j = 0; j < len1; ++j){
                if(s1[j] != s2[i + j]){
                    ++count;
                }
            }
            maxLen = Math.min(maxLen, count);
        }
        int res = (len2 - len1) * c + maxLen * d;
        System.out.println(res);
    }
    /*public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        String b = sc.nextLine();
        int c = sc.nextInt();
        int d = sc.nextInt();
        char[] s1 = a.toCharArray();
        char[] s2 = b.toCharArray();
        int len1 = s1.length, len2 = s2.length;

        int count1 = 0, count2 = 0;
        int len3 = len2 - len1;
        // 方案1
        count1 += len3 * c;
        for(int i = 0; i < len1; ++i){
            if(s1[i] != s2[i])
                count1 += d;
        }
        // 方案2
        count2 += len3 * c;
        for(int i = 0; i < len1; ++i){
            if(s1[i] != s2[i + len3])
                count2 += d;
        }
        System.out.println(Math.min(count1, count2));
    }*/
}
