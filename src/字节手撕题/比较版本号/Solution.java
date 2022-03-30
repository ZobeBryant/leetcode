package 字节手撕题.比较版本号;

import java.sql.SQLOutput;

public class Solution {
    public int compareVersion(String version1, String version2) {
        // 先对两个版本号进行格式处理，格式统一
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");
        int len1 = v1.length;
        int len2 = v2.length;
        int len = Math.max(len1, len2);
        int i = 0, n1, n2;
        while (i < len){
            n1 = i < len1 ? Integer.parseInt(v1[i]) : 0;
            n2 = i < len2 ? Integer.parseInt(v2[i]) : 0;
            if(n1 > n2)
                return 1;
            else if(n1 < n2)
                return -1;
            ++i;
        }
        return 0;
    }

    public static void main(String[] args) {

        String version1 = "1.0.1";
        String version2 = "1";
        Solution sl = new Solution();
        sl.compareVersion(version1, version2);

        // System.out.println(Integer.parseInt("0012"));
    }
}
