package 排序.最大数;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {

    public String largestNumber(int[] nums) {
        String[] asStr =new String[nums.length];
        for(int i=0;i<nums.length;++i){
            asStr[i]=String.valueOf(nums[i]);
        }

        Arrays.sort(asStr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                String nO1=o1+o2;
                String nO2=o2+o1;
                return nO2.compareTo(nO1);
            }
        });

        StringBuilder sb =new StringBuilder();
        for(int i=0; i<nums.length;++i){
            sb.append(asStr[i]);
        }
        if (sb.charAt(0)=='0')
            return "0";

        return sb.toString();
    }
}


