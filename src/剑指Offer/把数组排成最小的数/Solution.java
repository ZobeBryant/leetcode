package 剑指Offer.把数组排成最小的数;

import java.util.*;
import java.util.regex.Pattern;


public class Solution {

    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for(int i = 0; i < n; ++i){
            strs[i] = String.valueOf(nums[i]);
        }
        Arrays.sort(strs, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1 + o2).compareTo(o2 + o1);
            }
        });
        StringBuilder res = new StringBuilder();
        for(String  str: strs){
            res.append(str);
        }
        return res.toString();

    }
    // 小根堆
    public String minNumber2(int[] nums) {
        Queue<String> lowHeap = new PriorityQueue<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return (o1+o2).compareTo(o2+o1);
            }
        });
        for(int num: nums){
            lowHeap.add("" + num);
        }
        StringBuilder res = new StringBuilder();
        while (!lowHeap.isEmpty()){
            res.append(lowHeap.poll());
        }
        return res.toString();
    }

    public static void main(String[] args) {
//        int[] nums = {3,30,34,5,9};
//        Solution sl = new Solution();
//        sl.minNumber(nums);
//        System.out.println("330".compareTo("303"));
        Integer[] nums = {3,30,34,5,9};
        Arrays.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

    }
}
