package 排序.H指数;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    //排序
    public int hIndex(int[] citations) {
        Arrays.sort(citations);

        int i=0;
        while (i<citations.length && citations[citations.length-1-i]>i){
            ++i;
        }

        return i;
    }

    //计数
    public int hIndex2(int[] citations) {
        int n=citations.length;
        int[] papers = new int[n+1];
        for(int c:citations){
            papers[Math.min(n, c)]++;
        }
        int k=n;
        for (int s = papers[n];k>s; s+=papers[k]){
            --k;
        }
        return k;
    }
}